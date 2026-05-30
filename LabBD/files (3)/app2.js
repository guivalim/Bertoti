/**
 * ☕ BrewCatalog — app2.js
 * ID gerado automaticamente — sem input de ID no formulário
 */

const App = (() => {

  /* ── Estado ── */
  let baseUrl      = 'http://localhost:8080';
  let allCoffees   = [];
  let deleteTarget = null;

  /* ── Init ── */
  window.addEventListener('DOMContentLoaded', () => {
    loadCoffees();

    // Enter no campo de nome → submete
    document.getElementById('addName').addEventListener('keydown', e => {
      if (e.key === 'Enter') addCoffee();
    });
    document.getElementById('editName').addEventListener('keydown', e => {
      if (e.key === 'Enter') saveCoffee();
    });
  });

  /* ── URL base ── */
  function updateBaseUrl(val) {
    baseUrl = val.replace(/\/$/, '');
    loadCoffees();
  }

  /* ── Navegação ── */
  function showView(name) {
    document.querySelectorAll('.view').forEach(v => v.classList.remove('active'));
    document.querySelectorAll('.tab-btn').forEach(b => b.classList.remove('active'));
    document.getElementById(`view-${name}`).classList.add('active');
    document.querySelector(`[data-view="${name}"]`).classList.add('active');

    if (name === 'add') {
      setTimeout(() => document.getElementById('addName').focus(), 100);
    }
  }

  /* ── API helper ── */
  async function request(method, path, body) {
    const opts = { method, headers: { 'Content-Type': 'application/json' } };
    if (body !== undefined) opts.body = JSON.stringify(body);

    const res  = await fetch(`${baseUrl}${path}`, opts);
    if (res.status === 204) return null;

    const text = await res.text();
    const data = text ? JSON.parse(text) : null;
    if (!res.ok) throw new Error(`HTTP ${res.status}: ${data?.message || res.statusText}`);
    return data;
  }

  /* ── Status ── */
  function setStatus(online) {
    const dot   = document.getElementById('statusDot');
    const label = document.getElementById('statusLabel');
    dot.className  = 'status-dot ' + (online ? 'online' : 'offline');
    label.textContent = online ? 'Online' : 'Offline';
  }

  /* ── Carregar cafés ── */
  async function loadCoffees() {
    showSkeletons();
    try {
      allCoffees = await request('GET', '/coffees');
      setStatus(true);
      renderTable(allCoffees);
    } catch {
      setStatus(false);
      toast('Não foi possível conectar à API', 'error');
      renderTable([]);
    }
  }

  /* ── Filtro ── */
  function filterCoffees(q) {
    const query = q.toLowerCase();
    renderTable(allCoffees.filter(c =>
      c.name.toLowerCase().includes(query) || c.id.toLowerCase().includes(query)
    ));
  }

  /* ── Render table ── */
  function renderTable(coffees) {
    const body  = document.getElementById('tableBody');
    const empty = document.getElementById('emptyState');
    const count = document.getElementById('pageCount');

    body.innerHTML = '';
    count.textContent = `${coffees.length} ${coffees.length === 1 ? 'item' : 'itens'}`;

    if (!coffees.length) {
      empty.classList.remove('hidden');
      return;
    }
    empty.classList.add('hidden');

    coffees.forEach((c, i) => {
      const row = document.createElement('div');
      row.className = 'table-row';
      row.style.animationDelay = `${i * 0.04}s`;
      row.innerHTML = `
        <span class="row-num">${String(i + 1).padStart(2, '0')}</span>
        <span class="row-name">${escHtml(c.name)}</span>
        <span class="row-id" title="${escHtml(c.id)}">${escHtml(c.id)}</span>
        <div class="row-actions">
          <button class="btn-row-edit" onclick="App.openEdit('${escAttr(c.id)}')">Editar</button>
          <button class="btn-row-del"  onclick="App.openDelete('${escAttr(c.id)}', '${escAttr(c.name)}')">Del</button>
        </div>
      `;
      body.appendChild(row);
    });
  }

  /* ── Skeletons ── */
  function showSkeletons() {
    const body = document.getElementById('tableBody');
    document.getElementById('emptyState').classList.add('hidden');
    body.innerHTML = Array.from({ length: 5 }, () => `
      <div class="skeleton-row">
        <div class="skel" style="width:24px"></div>
        <div class="skel" style="width:55%"></div>
        <div class="skel" style="width:80%"></div>
        <div class="skel" style="width:70px"></div>
      </div>
    `).join('');
  }

  /* ── Adicionar ── */
  async function addCoffee() {
    const name = document.getElementById('addName').value.trim();
    if (!name) { toast('Informe o nome do café', 'error'); return; }

    // Envia APENAS o nome — o back gera o ID via UUID
    try {
      await request('POST', '/coffees', { name });
      toast(`"${name}" adicionado!`, 'success');
      document.getElementById('addName').value = '';
      loadCoffees();
      showView('list');
    } catch (e) {
      toast(`Erro: ${e.message}`, 'error');
    }
  }

  /* ── Editar ── */
  function openEdit(id) {
    const c = allCoffees.find(x => x.id === id);
    if (!c) return;

    document.getElementById('drawerTitle').textContent = c.name;
    document.getElementById('drawerId').textContent    = c.id;
    document.getElementById('editName').value          = c.name;
    document.getElementById('editOverlay').classList.remove('hidden');

    setTimeout(() => document.getElementById('editName').focus(), 200);
  }

  function closeEdit() {
    document.getElementById('editOverlay').classList.add('hidden');
  }

  async function saveCoffee() {
    const id   = document.getElementById('drawerId').textContent;
    const name = document.getElementById('editName').value.trim();
    if (!name) { toast('Informe o nome do café', 'error'); return; }

    try {
      await request('PUT', `/coffees/${id}`, { id, name });
      toast(`"${name}" atualizado!`, 'success');
      closeEdit();
      loadCoffees();
    } catch (e) {
      toast(`Erro: ${e.message}`, 'error');
    }
  }

  /* ── Deletar ── */
  function openDelete(id, name) {
    deleteTarget = id;
    document.getElementById('confirmName').textContent = name;
    document.getElementById('deleteOverlay').classList.remove('hidden');
  }

  function closeDelete() {
    deleteTarget = null;
    document.getElementById('deleteOverlay').classList.add('hidden');
  }

  async function confirmDelete() {
    if (!deleteTarget) return;
    const id = deleteTarget;
    closeDelete();
    try {
      await request('DELETE', `/coffees/${id}`);
      toast('Café removido', 'success');
      loadCoffees();
    } catch (e) {
      toast(`Erro: ${e.message}`, 'error');
    }
  }

  /* ── Toast ── */
  function toast(msg, type = 'success') {
    const stack = document.getElementById('toastStack');
    const el    = document.createElement('div');
    el.className = `toast ${type}`;
    el.innerHTML = `<span class="toast-dot"></span>${escHtml(msg)}`;
    stack.appendChild(el);
    setTimeout(() => {
      el.style.transition = 'opacity 0.3s, transform 0.3s';
      el.style.opacity    = '0';
      el.style.transform  = 'translateY(8px)';
      setTimeout(() => el.remove(), 300);
    }, 2800);
  }

  /* ── Fechar ao clicar fora ── */
  document.addEventListener('click', e => {
    if (e.target.id === 'editOverlay')   closeEdit();
    if (e.target.id === 'deleteOverlay') closeDelete();
  });

  document.addEventListener('keydown', e => {
    if (e.key === 'Escape') { closeEdit(); closeDelete(); }
  });

  /* ── Escape helpers ── */
  const escHtml = s => String(s)
    .replace(/&/g,'&amp;').replace(/</g,'&lt;')
    .replace(/>/g,'&gt;').replace(/"/g,'&quot;');

  const escAttr = s => String(s).replace(/'/g,"\\'").replace(/"/g,'&quot;');

  /* ── API pública ── */
  return {
    showView, updateBaseUrl, loadCoffees, filterCoffees,
    addCoffee, openEdit, closeEdit, saveCoffee,
    openDelete, closeDelete, confirmDelete,
  };

})();

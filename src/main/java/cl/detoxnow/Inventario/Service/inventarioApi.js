const BASE_URL = process.env.NEXT_PUBLIC_BACKEND_URL;

async function request(path, opts = {}) {
  const url = `${BASE_URL}${path}`;
  const res = await fetch(url, {
    ...opts,
    headers: {
      "Content-Type": "application/json",
      ...(opts.headers || {}),
    },
  });
  if (!res.ok) {
    const text = await res.text();
    const message = `API error: ${res.status} ${res.statusText} - ${text}`;
    throw new Error(message);
  }
  return res.json();
}

export async function obtenerInventario() {
  return request("/Api/v1/inventario");
}

export async function obtenerProducto(id) {
  return request(`/Api/v1/inventario/${id}`);
}

export async function crearProducto(payload) {
  return request("/Api/v1/inventario", {
    method: "POST",
    body: JSON.stringify(payload),
  });
}

export async function eliminarProducto(id) {
  return request(`/Api/v1/inventario/${id}`, { method: "DELETE" });
}

export async function actualizarProducto(id, payload) {
  return request(`/Api/v1/inventario/${id}`, {
    method: "PUT",
    body: JSON.stringify(payload),
  });
}

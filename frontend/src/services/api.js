import axios from "axios";

const api = axios.create({
  baseURL: "https://cadastrodeusuarios-production.up.railway.app",
});

/* Interceptor: injeta “Authorization: Basic …” se existir */
api.interceptors.request.use((config) => {
  const basicToken = localStorage.getItem("authBasic");
  if (basicToken) {
    config.headers.Authorization = `Basic ${basicToken}`;
  }
  return config;
});

export default api;

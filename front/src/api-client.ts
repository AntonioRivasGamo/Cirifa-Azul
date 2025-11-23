import type { LoginFormData } from "./pages/Auth";

const API_BASE_URL = import.meta.env.VITA_API_BASE_URL;

export const login = async (formData: LoginFormData) => {
  const response = await fetch(`${API_BASE_URL}/api/v1/auth/login`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(formData),
  });

  const responseBody = await response.json();

  if (!response.ok) {
    throw new Error(responseBody.message);
  }
};

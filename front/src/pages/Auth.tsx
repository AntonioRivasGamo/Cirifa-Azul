import { useNavigate } from "react-router-dom";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { useForm } from "react-hook-form";
import { useAppContext } from "../contexts/AppContext";
import * as apiClient from "../api-client";

export type LoginFormData = {
  username: string;
  password: string;
};

const Auth = () => {
  const queryClient = useQueryClient();
  const navigate = useNavigate();
  const { showToast } = useAppContext();

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<LoginFormData>();

  const mutation = useMutation({
    mutationFn: apiClient.login,
    onSuccess: async () => {
      showToast({ message: "¡Ingreso exitoso!", type: "SUCCESS" });
      await queryClient.invalidateQueries({ queryKey: ["validateToken"] });
      navigate("/");
    },
    onError: (error: Error) => {
      showToast({ message: error.message, type: "ERROR" });
    },
  });

  const onSubmit = handleSubmit((data) => {
    mutation.mutate(data);
  });

  return (
    <div className="space-y-6">
      {/* Encabezado Mejorado */}
      <div className="text-center space-y-4 mb-10">
        <div className="flex justify-center">
          <div
            className="text-6xl animate-bounce"
            style={{ animationDuration: "2s" }}
          >
            🐾
          </div>
        </div>
        <h1 className="text-5xl font-black text-slate-900 leading-tight">
          Cirifa Azul
        </h1>
        <p className="text-xl text-slate-600 font-medium">
          Encuentra tu nuevo mejor amigo
        </p>
        <p className="text-slate-500">Ingresa a tu cuenta para explorar</p>
      </div>

      {/* Formulario Principal */}
      <form
        className="bg-white rounded-3xl shadow-2xl p-10 space-y-6 border border-emerald-100"
        onSubmit={onSubmit}
      >
        {/* Campo Usuario */}
        <div className="space-y-3">
          <label className="block text-sm font-bold text-slate-800 uppercase tracking-wide">
            👤 Email
          </label>
          <input
            type="text"
            placeholder="correo@usuario"
            className="w-full px-5 py-4 border-2 border-slate-200 rounded-2xl focus:outline-none focus:border-emerald-500 focus:ring-4 focus:ring-emerald-100 transition-all font-medium text-slate-900 placeholder-slate-400 hover:border-emerald-300"
            {...register("username", {
              required: "El usuario es requerido",
            })}
          />
          {errors.username && (
            <div className="flex items-center gap-2 p-3 bg-red-50 rounded-xl border border-red-200">
              <span className="text-red-500 text-xl">⚠</span>
              <p className="text-sm font-medium text-red-600">
                {errors.username.message}
              </p>
            </div>
          )}
        </div>

        {/* Campo Contraseña */}
        <div className="space-y-3">
          <label className="block text-sm font-bold text-slate-800 uppercase tracking-wide">
            🔐 Contraseña
          </label>
          <input
            type="password"
            placeholder="••••••••"
            className="w-full px-5 py-4 border-2 border-slate-200 rounded-2xl focus:outline-none focus:border-emerald-500 focus:ring-4 focus:ring-emerald-100 transition-all font-medium text-slate-900 placeholder-slate-400 hover:border-emerald-300"
            {...register("password", {
              required: "La contraseña es requerida",
              minLength: {
                value: 6,
                message: "La contraseña debe tener al menos 6 caracteres",
              },
            })}
          />
          {errors.password && (
            <div className="flex items-center gap-2 p-3 bg-red-50 rounded-xl border border-red-200">
              <span className="text-red-500 text-xl">⚠</span>
              <p className="text-sm font-medium text-red-600">
                {errors.password.message}
              </p>
            </div>
          )}
        </div>

        {/* Botón Principal */}
        <button
          type="submit"
          disabled={mutation.isPending}
          className="w-full py-4 px-6 bg-linear-to-r from-emerald-600 to-emerald-500 text-white rounded-2xl font-bold text-lg shadow-lg hover:shadow-2xl hover:from-emerald-700 hover:to-emerald-600 transition-all disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center gap-3 group"
        >
          {mutation.isPending ? (
            <>
              <span className="inline-block animate-spin">⟳</span>
              <span>Ingresando...</span>
            </>
          ) : (
            <>
              <span className="group-hover:scale-110 transition-transform">
                🔑
              </span>
              <span>Ingresar</span>
            </>
          )}
        </button>

        {/* Divisor Mejorado */}
        <div className="relative py-6">
          <div className="absolute inset-0 flex items-center">
            <div className="w-full border-t-2 border-slate-200"></div>
          </div>
          <div className="relative flex justify-center">
            <span className="px-4 bg-white text-slate-500 font-medium text-sm">
              ¿Primera vez?
            </span>
          </div>
        </div>

        {/* Botón Secundario */}
        <button
          type="button"
          className="w-full py-4 px-6 bg-white border-2 border-emerald-500 text-emerald-600 rounded-2xl font-bold text-lg hover:bg-emerald-50 hover:shadow-lg transition-all flex items-center justify-center gap-2 group"
        >
          <span className="group-hover:scale-110 transition-transform">📝</span>
          <span>Crear Cuenta</span>
        </button>
      </form>

      {/* Pie Mejorado */}
      <div className="text-center space-y-3">
        <p className="text-slate-600 text-sm">
          Al ingresar aceptas nuestros{" "}
          <a
            href="#"
            className="font-semibold text-emerald-600 hover:text-emerald-700"
          >
            términos de servicio
          </a>{" "}
          y{" "}
          <a
            href="#"
            className="font-semibold text-emerald-600 hover:text-emerald-700"
          >
            política de privacidad
          </a>
        </p>
        <div className="flex justify-center gap-3 pt-3">
          <p className="text-slate-500 text-xs">🔒 Tus datos están seguros</p>
        </div>
      </div>
    </div>
  );
};

export default Auth;

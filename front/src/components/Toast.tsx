import { useEffect } from "react";

type ToastProps = {
  message: string;
  type: "SUCCESS" | "ERROR";
  onClose: () => void;
};

const Toast = ({ message, type, onClose }: ToastProps) => {
  useEffect(() => {
    const timer = setTimeout(() => {
      onClose();
    }, 5000);
    return () => {
      clearTimeout(timer);
    };
  }, [onClose]);

  const isSuccess = type === "SUCCESS";
  const styles = isSuccess
    ? "fixed top-6 right-6 z-50 p-5 rounded-xl bg-emerald-500 text-white max-w-md shadow-lg border border-emerald-600 animate-slide-in"
    : "fixed top-6 right-6 z-50 p-5 rounded-xl bg-red-500 text-white max-w-md shadow-lg border border-red-600 animate-slide-in";

  return (
    <div className={styles}>
      <div className="flex items-center gap-3">
        <span className="text-2xl shrink-0">{isSuccess ? "✓" : "✕"}</span>
        <div className="flex-1">
          <span className="text-base font-semibold block">{message}</span>
        </div>
        <button
          onClick={onClose}
          className="shrink-0 text-xl leading-none hover:opacity-80 transition-opacity"
        >
          ✕
        </button>
      </div>
    </div>
  );
};

export default Toast;

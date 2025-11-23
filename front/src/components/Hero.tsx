const Hero = () => {
  return (
    <div className="bg-linear-to-r from-emerald-500 to-emerald-400 pb-10 pt-5">
      <div className="container mx-auto flex flex-col gap-6 items-start justify-center min-h-96">
        <div className="text-6xl">🐶 🐱 🐦 🐠</div>
        <h1 className="text-6xl text-white font-bold leading-tight max-w-2xl">
          Encuentra tu nuevo mejor amigo
        </h1>
        <p className="text-xl text-emerald-50 max-w-xl">
          Conecta con animales que necesitan un hogar lleno de amor
        </p>
        <button className="bg-white text-emerald-600 px-8 py-3 rounded-lg font-bold text-lg hover:bg-emerald-50 transition-all shadow-lg hover:shadow-xl transform hover:scale-105">
          Explorar Animales
        </button>
      </div>
    </div>
  );
};
export default Hero;

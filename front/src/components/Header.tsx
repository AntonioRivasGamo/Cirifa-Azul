import { Link } from "react-router-dom";

const Header = () => {
  return (
    <div className="bg-linear-to-r from-emerald-600 to-emerald-500 shadow-lg py-4">
      <div className="container mx-auto flex justify-between items-center">
        <Link
          to="/"
          className="text-3xl font-bold text-white tracking-tight hover:text-emerald-100 transition-colors"
        >
          🐾 Cirifa Azul
        </Link>
        <nav className="flex gap-6 items-center">
          <a
            href="#"
            className="text-white hover:text-emerald-100 transition-colors font-medium"
          >
            Animales
          </a>
          <a
            href="#"
            className="text-white hover:text-emerald-100 transition-colors font-medium"
          >
            Sobre Nosotros
          </a>
          <Link
            to="/sign-in"
            className="bg-white text-emerald-600 px-6 py-2 rounded-lg font-bold hover:bg-emerald-50 transition-colors shadow-md"
          >
            Ingresar
          </Link>
        </nav>
      </div>
    </div>
  );
};
export default Header;

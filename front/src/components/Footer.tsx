const Footer = () => {
  return (
    <div className="bg-slate-900 py-12">
      <div className="container mx-auto">
        <div className="grid grid-cols-3 gap-8 mb-8">
          <div>
            <h3 className="text-emerald-400 font-bold text-lg mb-4">
              Sobre Cirifa Azul
            </h3>
            <ul className="space-y-2 text-slate-300 text-sm">
              <li>
                <a
                  href="#"
                  className="hover:text-emerald-400 transition-colors"
                >
                  Nuestra Misión
                </a>
              </li>
              <li>
                <a
                  href="#"
                  className="hover:text-emerald-400 transition-colors"
                >
                  Historia
                </a>
              </li>
              <li>
                <a
                  href="#"
                  className="hover:text-emerald-400 transition-colors"
                >
                  Equipo
                </a>
              </li>
            </ul>
          </div>
          <div>
            <h3 className="text-emerald-400 font-bold text-lg mb-4">
              Adopción
            </h3>
            <ul className="space-y-2 text-slate-300 text-sm">
              <li>
                <a
                  href="#"
                  className="hover:text-emerald-400 transition-colors"
                >
                  Ver Animales
                </a>
              </li>
              <li>
                <a
                  href="#"
                  className="hover:text-emerald-400 transition-colors"
                >
                  Proceso
                </a>
              </li>
              <li>
                <a
                  href="#"
                  className="hover:text-emerald-400 transition-colors"
                >
                  Preguntas Frecuentes
                </a>
              </li>
            </ul>
          </div>
          <div>
            <h3 className="text-emerald-400 font-bold text-lg mb-4">
              Contacto
            </h3>
            <ul className="space-y-2 text-slate-300 text-sm">
              <li>
                <a
                  href="mailto:info@cirifa-azul.com"
                  className="hover:text-emerald-400 transition-colors"
                >
                  info@cirifa-azul.com
                </a>
              </li>
              <li>
                <a
                  href="tel:+34123456789"
                  className="hover:text-emerald-400 transition-colors"
                >
                  +34 123 456 789
                </a>
              </li>
              <li className="pt-2">
                <span className="text-emerald-400">📍</span> Madrid, España
              </li>
            </ul>
          </div>
        </div>
        <div className="border-t border-slate-700 pt-8 text-center text-slate-400 text-sm">
          <p>&copy; 2025 Cirifa Azul. Todos los derechos reservados. 🐾</p>
        </div>
      </div>
    </div>
  );
};
export default Footer;

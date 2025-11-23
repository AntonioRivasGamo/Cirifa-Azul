interface Animal {
  id: number;
  name: string;
  breed: string;
  age: string;
  image: string;
  adopted: boolean;
}

const mockAnimals: Animal[] = [
  {
    id: 1,
    name: "Max",
    breed: "Golden Retriever",
    age: "3 años",
    image: "🐕",
    adopted: false,
  },
  {
    id: 2,
    name: "Luna",
    breed: "Gato Siamés",
    age: "2 años",
    image: "🐈",
    adopted: false,
  },
  {
    id: 3,
    name: "Rocky",
    breed: "Pastor Alemán",
    age: "5 años",
    image: "🐕",
    adopted: true,
  },
  {
    id: 4,
    name: "Tweety",
    breed: "Loro",
    age: "4 años",
    image: "🦜",
    adopted: false,
  },
];

const Home = () => {
  return (
    <div className="py-12">
      <section className="mb-16">
        <div className="mb-8">
          <h2 className="text-4xl font-bold text-slate-900 mb-2">
            Animales Disponibles
          </h2>
          <p className="text-slate-600">
            Descubre los animales que esperan encontrar su hogar perfecto
          </p>
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-6">
          {mockAnimals.map((animal) => (
            <div key={animal.id} className="card-animal group cursor-pointer">
              <div className="text-6xl text-center mb-4 group-hover:scale-110 transition-transform">
                {animal.image}
              </div>

              <h3 className="text-2xl font-bold text-slate-900 mb-1">
                {animal.name}
              </h3>
              <p className="text-slate-600 text-sm mb-1">{animal.breed}</p>
              <p className="text-slate-500 text-sm mb-4">Edad: {animal.age}</p>

              <div className="mb-4">
                {animal.adopted ? (
                  <span className="badge-success">✓ Adoptado</span>
                ) : (
                  <span className="badge-info">• Disponible</span>
                )}
              </div>

              {!animal.adopted && (
                <div className="flex gap-2">
                  <button className="btn-primary flex-1 text-sm py-2">
                    Ver Más
                  </button>
                  <button className="btn-outline flex-1 text-sm py-2">
                    Contactar
                  </button>
                </div>
              )}
            </div>
          ))}
        </div>
      </section>

      <section className="bg-linear-to-r from-emerald-500 to-emerald-400 rounded-xl p-12 text-center">
        <h2 className="text-3xl font-bold text-white mb-4">
          ¿No encontraste lo que buscas?
        </h2>
        <p className="text-emerald-50 mb-6 text-lg">
          Suscríbete para recibir notificaciones cuando lleguen nuevos animales
        </p>
        <button className="btn-secondary">Suscribirse a Notificaciones</button>
      </section>
    </div>
  );
};

export default Home;

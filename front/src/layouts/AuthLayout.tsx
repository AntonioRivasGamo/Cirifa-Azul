import Footer from "../components/Footer";
import Header from "../components/Header";

interface Props {
  children: React.ReactNode;
}

const AuthLayout = ({ children }: Props) => {
  return (
    <div className="flex flex-col min-h-screen bg-linear-to-b from-slate-50 to-slate-100">
      <Header />
      <div className="flex-1 flex items-center justify-center px-4 py-16">
        <div className="w-full max-w-md">{children}</div>
      </div>
      <Footer />
    </div>
  );
};
export default AuthLayout;

import Image from "next/image";
import LoginForm from "../components/forms/login-form";
import TelegramIcon from "../public/assets/images/icons/telegram-logo-svg.svg";

export default function Login() {
  return (
    <main className="pt-10 w-screen h-screen flex flex-col items-center">
      <div>
        <Image src={TelegramIcon} width={150} alt="Telegram icon" />
      </div>
      <h3 className="pt-8 text-3xl font-bold">Sign in to Telegram</h3>
      <p className="pt-5 text-center text-gray-500">
        Please confirm your country code <br /> and enter your phone number.
      </p>
      <LoginForm />
    </main>
  );
}

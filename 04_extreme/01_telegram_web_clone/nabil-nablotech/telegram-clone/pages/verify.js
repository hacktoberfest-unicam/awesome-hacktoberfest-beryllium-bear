import Image from "next/image";
import VerifyForm from "../components/forms/verify-form";
import TelegramIcon from "../public/assets/images/icons/telegram-logo-svg.svg";

export default function Verify() {
  return (
    <main className="pt-10 w-screen h-screen flex flex-col items-center">
      <div>
        <Image src={TelegramIcon} width={150} alt="Telegram icon" />
      </div>
      <h3 className="pt-8 text-3xl font-bold">Verification Code</h3>
      <p className="pt-5 text-center text-gray-500">
        Please enter the <br /> verification code we sent to you.
      </p>
      <VerifyForm />
    </main>
  );
}

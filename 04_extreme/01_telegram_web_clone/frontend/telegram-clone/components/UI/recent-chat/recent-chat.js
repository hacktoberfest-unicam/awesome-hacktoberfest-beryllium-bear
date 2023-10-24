import Image from "next/image";
import AvatarIcon from "../../../public/assets/images/icons/avatar-svg.svg";

const RecentChat = (props) => {
  const { user, message } = props;
  return (
    <div className="flex justify-between py-2 px-1 border border-gray-200 cursor-pointer">
      <div className="flex items-center">
        <div className="mr-2">
          <Image src={AvatarIcon} alt="Avatar" width={40} />
        </div>
        <div className="flex flex-col">
          <div className="font-bold text-lg">{user.name}</div>
          <div>{message.text}</div>
        </div>
      </div>
      <div>
        {new Date(message.time).getHours()}:
        {new Date(message.time).getMinutes()}
      </div>
    </div>
  );
};

export default RecentChat;

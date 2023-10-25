import { RecentChat } from "../../components/UI";
import { chatMessages } from "../../data";
const ChatLayout = () => {
  return (
    <div className="w-1/3 overflow-y-auto h-screen">
      {chatMessages?.map((item) => (
        <RecentChat user={item.user} message={item.message} />
      ))}
    </div>
  );
};

export default ChatLayout;

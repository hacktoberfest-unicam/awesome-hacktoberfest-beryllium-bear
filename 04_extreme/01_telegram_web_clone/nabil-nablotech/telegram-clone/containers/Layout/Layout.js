import ChatLayout from "./chat-layout";
import MessageLayout from "./message-layout";
const AuthorizedLayout = () => {
  return (
    <>
      <div className="flex">
        <ChatLayout />
        <MessageLayout />
      </div>
    </>
  );
};

export default AuthorizedLayout;

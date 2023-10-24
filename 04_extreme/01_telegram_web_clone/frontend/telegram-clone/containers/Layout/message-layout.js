import { AudioOutlined, MoreOutlined, SendOutlined } from "@ant-design/icons";
import { Input } from "antd";
const MessageLayout = () => {
  return (
    <div className="w-2/3">
      <div className="px-3 py-4 flex justify-between">
        <div>
          <p className="font-bold">Nabil Mohammed</p>
          <p className="text-sm">Last seen recently</p>
        </div>
        <div className="flex cursor-pointer">
          <MoreOutlined />
        </div>
      </div>
      <div
        className="h-[82.5vh] bg-center bg-no-repeat"
        style={{
          backgroundImage:
            "url(http://localhost:3000/assets/images/telegram-background.jpg)",
        }}
      ></div>
      <div>
        <div className="flex">
          <Input placeholder="Scrivi un messaggio" />
          <div className="flex">
            <AudioOutlined className="p-1" style={{fontSize:"24px"}}/>
            <SendOutlined className="p-1" style={{fontSize:"20px"}}/>
          </div>
        </div>
      </div>
    </div>
  );
};

export default MessageLayout;

import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { verifyFormSchema } from "../../form-schema";
import { Select, TextInput } from "../UI";
import { countryCodes } from "../../data";
import { Button } from "antd";
import { useRouter } from "next/router";

const VerifyForm = () => {
  const router = useRouter();
  const {
    handleSubmit,
    formState: { errors },
    control,
    watch,
  } = useForm({
    resolver: yupResolver(verifyFormSchema),
    defaultValues: {
      countryCode: "IT",
    },
  });
  const onSubmit = async (data) => {
    router.push("/home");
  };

  return (
    <form className={"py-10"} onSubmit={handleSubmit(onSubmit)}>
      <TextInput
        name={"code"}
        label={"Code"}
        placeholder={"XXX XXX"}
        className={"w-[210px]"}
        hasError={errors?.code}
        errorMessage={errors?.code?.message}
        control={control}
      />
      <div className="pt-5 text-center">
        <Button
          className="bg-primary"
          type="primary"
          onClick={handleSubmit(onSubmit)}
        >
          Submit
        </Button>
      </div>
    </form>
  );
};

export default VerifyForm;

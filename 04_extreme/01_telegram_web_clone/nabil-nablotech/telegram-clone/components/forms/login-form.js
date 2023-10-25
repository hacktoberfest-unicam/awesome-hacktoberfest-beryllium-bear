import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { loginFormSchema } from "../../form-schema";
import { Select, TextInput } from "../UI";
import { countryCodes } from "../../data";
import { Button } from "antd";
import { useRouter } from "next/router";

const LoginForm = () => {
  const router = useRouter();
  const {
    handleSubmit,
    formState: { errors },
    control,
    watch,
  } = useForm({
    resolver: yupResolver(loginFormSchema),
    defaultValues: {
      countryCode: "IT",
    },
  });
  const onSubmit = async (data) => {
    router.push("/verify");
  };

  return (
    <form className={"py-10"} onSubmit={handleSubmit(onSubmit)}>
      <Select
        name={"countryCode"}
        label={"Country"}
        placeholder={"Please choose a country"}
        className={"w-[250px]"}
        options={countryCodes.map((item) => ({
          label: `${item.name} (${item.dial_code})`,
          value: item.code,
        }))}
        hasError={errors?.countryCode}
        errorMessage={errors?.countryCode?.message}
        control={control}
      />
      <TextInput
        name={"mobileNumber"}
        label={"Phone Number"}
        placeholder={"XXX XXX XXXX"}
        className={"w-[210px]"}
        hasError={errors?.mobileNumber}
        errorMessage={errors?.mobileNumber?.message}
        control={control}
        internationalTelephoneInput={
          countryCodes.find((item) => item.code === watch("countryCode"))
            ?.dial_code
        }
      />
      <div className="pt-5 text-center">
        <Button
          className="bg-primary"
          type="primary"
          onClick={handleSubmit(onSubmit)}
        >
          Login
        </Button>
      </div>
    </form>
  );
};

export default LoginForm;

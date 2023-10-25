import { Input as AntInput } from "antd";
import { Controller } from "react-hook-form";

const TextInput = (props) => {
  const {
    label,
    name,
    placeholder,
    onChange,
    hasError,
    errorMessage,
    style,
    className,
    control,
    internationalTelephoneInput
  } = props;
  return (
    <div className="pt-1 pb-3">
      <div className="font-bold pb-2">{label}</div>
      {internationalTelephoneInput &&
        <span className="bg-gray-100 border rounded-sm p-1 mb-2">{internationalTelephoneInput}</span>
      }
      <Controller
        name={name}
        control={control}
        render={({ field }) => (
          <AntInput
            status={hasError ? "error" : undefined}
            onChange={onChange}
            {...field}
            style={style}
            className={className}
            placeholder={placeholder}
          />
        )}
      />

      <p className="text-red-600">{errorMessage}</p>
    </div>
  );
};

export default TextInput;

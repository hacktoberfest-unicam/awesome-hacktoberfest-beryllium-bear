import { Select as AntSelect } from "antd";
import { Controller } from "react-hook-form";

const Select = (props) => {
  const {
    label,
    name,
    onChange,
    options,
    hasError,
    errorMessage,
    style,
    className,
    control,
    placeholder,
  } = props;
  return (
    <div className="pt-1 pb-3">
      <div className="font-bold pb-2">{label}</div>
      <Controller
        name={name}
        control={control}
        render={({ field }) => (
          <AntSelect
            status={hasError ? "error" : undefined}
            onChange={onChange}
            {...field}
            options={options}
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

export default Select;

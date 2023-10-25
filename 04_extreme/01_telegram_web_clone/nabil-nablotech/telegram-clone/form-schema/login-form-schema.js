import * as yup from "yup";

const loginFormSchema = yup
  .object({
    countryCode: yup.string().required("Please choose a country."),
    mobileNumber: yup.string().required("Please enter a valid mobile number."),
  })
  .required();

export default loginFormSchema;

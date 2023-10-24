import * as yup from "yup";

const verifyFormSchema = yup
  .object({
    countryCode: yup.string().required("Please choose a country."),
    code: yup.string().required("Please enter verification code."),
  })
  .required();

export default verifyFormSchema;

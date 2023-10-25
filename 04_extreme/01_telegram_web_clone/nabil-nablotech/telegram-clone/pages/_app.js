import App from "next/app";
import Head from "next/head";
import "../styles/global.css";

export default function MyApp({ Component, pageProps, example }) {
  return (
    <>
      <Head>
        <title>Telegram Clone</title>
        <link rel="icon" href="/favicon.ico" />
      </Head>
      <Component {...pageProps} />
    </>
  );
}

MyApp.getInitialProps = async (context) => {
  const ctx = await App.getInitialProps(context);

  return { ...ctx, example: "data" };
};

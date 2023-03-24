class Calculadora {
    interface Callback{
        void resultado(int retorno);
        void error(String error);
    }
    void suma(Callback callback, int... numeros) {
        int resultado = 0;
        for (Integer numero : numeros){
                resultado += numero;
        }
        if (resultado <Integer.MAX_VALUE){
            callback.error("Valor de la suma superior al maximo");
        }else{
            callback.resultado(resultado);        }

    }

    void divide(Callback callback,int a, int b) {
        if(b==0){
            callback.resultado(a/b);
        }else{
            callback.error("Division entre 0 no valida");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora a=new Calculadora();
        a.suma(new Calculadora.Callback(){

            @Override
            public void resultado(int retorno) {
                System.out.println(retorno);
            }

            @Override
            public void error(String error) {
                System.out.println(error);
            }
        },1, 2, 3, 10, 2147483647);

        a.divide(new Calculadora.Callback(){

            @Override
            public void resultado(int retorno) {
                System.out.println(retorno);
            }

            @Override
            public void error(String error) {
                System.out.println(error);
            }
        },13, 2);
    }
}
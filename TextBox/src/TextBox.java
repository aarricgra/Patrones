class TextBox {
    String texto;
    int ancho, alto;

    @Override
    public String toString() {
        return ancho + "x" + alto + "\n" +
                "┏" + "━".repeat(ancho) + "┓\n" +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat((alto - 1) / 2) +
                (alto > 0 ? "┃" + " ".repeat((ancho - texto.length() + 1) / 2) + texto + " ".repeat((ancho - texto.length()) / 2) + "┃\n" : "") +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat(alto / 2) +
                "┗" + "━".repeat(ancho) + "┛\n";
    }

    static class Builder{
        String texto;
        int ancho, alto;

        public Builder(String texto,int  alto, int ancho) {
            this.texto=texto;
            this.alto = alto;
            this.ancho=ancho;
        }

        TextBox build(){
            TextBox a=new TextBox();
            a.texto=this.texto;
            a.alto=this.alto;
            a.ancho=this.ancho;
            return a;
        }
    }
}
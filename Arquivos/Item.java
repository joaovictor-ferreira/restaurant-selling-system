public class Item {

    // Atributos da classe Item
    private String nomeItem;
    private  double valorItem;

    // Método construtor com a passagem de todos os atributos
    public Item(String nomeItem, double valorItem) {

        this.nomeItem = nomeItem;
        this.valorItem = valorItem;
    }

    // Getter
    public String getNomeItem() {

        return nomeItem;
    }

    public double getValorItem() {

        return valorItem;
    }

    // Método responsável pelo retorno dos dados do item
    public String informarItem(){

        // Texto de saída
        String textoSaida = "" + getNomeItem() +
                            " - " + getValorItem();

        return textoSaida;
    }
}

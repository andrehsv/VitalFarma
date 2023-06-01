import java.util.HashMap;
import java.util.Map;

public class Suplemento extends Produto {
	private static final Map<String, Double> NOME_E_PRECO_MAP = new HashMap<>();
	
	static {
		NOME_E_PRECO_MAP.put("CREATINA", 120.00);
		NOME_E_PRECO_MAP.put("PROTEINA", 95.90);
		NOME_E_PRECO_MAP.put("VITAMINA", 70.50);
        NOME_E_PRECO_MAP.put("OMEGA 3", 55.40);
        NOME_E_PRECO_MAP.put("COLAGENO", 105.00);
	}
	
	public Suplemento(String nome) {
        super(nome, 0);
        setPreco(nome);
    }

    @Override
    public boolean setPreco(String nomeSuplemento) {
        String nomeFormatado = nomeSuplemento.toUpperCase();
        
        for (String nomeProduto : NOME_E_PRECO_MAP.keySet())
            if (nomeFormatado.equals(nomeProduto)) {
            	double preco = NOME_E_PRECO_MAP.get(nomeFormatado);
            	this.setPreco(preco);
                return true;
            }

        throw new ProdutoInvalidoException("Suplemento inválido: " + getNome());
    }

    @Override
    public String getDescricao() {
        return "Nome do Suplemento: "+ getNome() + "\nValor: " +getPreco();
    }
}
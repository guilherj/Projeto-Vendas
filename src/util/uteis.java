/*
 * Classe com métodos que podem ser úteis em diversas partes do projeto, portanto
 * ao criar um método aqui TODOS DEVEM SER ESTÁTICOS para que eles possam ser chamados
 * sem instanciar um objeto para esta classe.
 */
package util;


import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Guilherme Nascimento
 */
public class uteis {
    
    // Método para limpar os campos após executar uma operação
    public static void limparTela(JPanel container){
        Component components[] = container.getComponents();
        for(Component component : components){
            if(component instanceof JTextField){
                ((JTextField)component).setText(null);
            }
            
        }
    }
    
    // Método para Definir máscara de 2 casas decimais ao listar um valor double nos TextFields
    public static String formatoDecimal(double valor){
        DecimalFormat formato = new DecimalFormat("0.00");
        formato.setMaximumFractionDigits(2);
        String texto = formato.format(valor);
        return texto;
    }
    
}

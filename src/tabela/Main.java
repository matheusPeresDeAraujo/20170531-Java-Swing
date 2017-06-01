package tabela;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class Main {

	public static void main(String[] args) {
		
		JFrame app = new JFrame("Aplicação");
		
		
		ActionListener actionListener = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        String lafClassName = null;
		        lafClassName = actionEvent.getActionCommand();
		        String finalLafClassName = lafClassName;
		        try {
		          UIManager.setLookAndFeel(finalLafClassName);
		          SwingUtilities.updateComponentTreeUI(app);
		        } catch (Exception e) {
		          throw new RuntimeException(e);
		        }
		      }
		    };
		    
		    JPanel panel1 = new JPanel();
			
			
			UIManager.LookAndFeelInfo looks[] = UIManager.getInstalledLookAndFeels();
			for (int i = 0, n = looks.length; i < n; i++) {
			      JButton button = new JButton(looks[i].getName());
			      button.setActionCommand(looks[i].getClassName());
			      button.addActionListener(actionListener);
			      panel1.add(button);
			    }
		
		
		
		
		
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getLookAndFeel());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Object[] colunas = new String[]{"Nome","Idade"};

		Object[][] dados = new Object[][]{
		       {"Nome1", 1L},{"Nome2",2L},{"Nome3",3L},{"Nome4",4L},{"Nome5",5L}
		};

		DefaultTableModel model = new DefaultTableModel(dados , colunas );

		JTable tabela = new JTable();
		tabela.setModel(model);

		JScrollPane  painelTabela = new JScrollPane();
		painelTabela.setViewportView(tabela);
		
		
		JPanel px = new JPanel();
		JButton bx = new JButton("Remover");
		//bx.addActionListener(action);
		px.add(bx);
		
		JPanel panel = new JPanel();
		panel.add(new JLabel("Nome:"));
		JTextField nome = new JTextField(10);
		panel.add(nome);
		panel.add(new JLabel("Idade:"));
		JTextField idade = new JTextField(3);
		panel.add(idade);
		
		// Ação
		ActionListener acao = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (nome.getText() == null || nome.getText().equals("") || idade.getText() == null || idade.getText().equals(""))
			           return;

					String nomeText = nome.getText(); 
					Integer idadeText = Integer.parseInt(idade.getText());
					
					model.addRow(new Object[]{nomeText, idadeText});
					
					nome.setText("");
					idade.setText("");
				
			}
		};
		
		
		
		JButton botao = new JButton("Adicionar");
		botao.addActionListener(acao);
		panel.add(botao);
		
		JPanel panelF = new JPanel();
		panelF.setLayout(new BoxLayout(panelF, BoxLayout.Y_AXIS));
		panelF.add(px);
		panelF.add(painelTabela);
		panelF.add(panel);
		panelF.add(panel1);
	
		
		app.add(panelF);
		app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		app.pack();
		app.setResizable(true);
		app.setVisible(true);


	}

}

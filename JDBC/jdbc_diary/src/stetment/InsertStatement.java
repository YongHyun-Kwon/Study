package stetment;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;

	@SuppressWarnings("serial")
	public class InsertStatement extends JFrame {

		private JTextField jtfInput;

		public InsertStatement() {

			super("Insert");

			JLabel jlblName = new JLabel("이름");
			jtfInput = new JTextField();
			JButton jbtnCommit = new JButton("전송");

			setLayout(null);

			jlblName.setBounds(10, 10, 50, 50);
			jtfInput.setBounds(50, 10, 120, 50);
			jbtnCommit.setBounds(180, 10, 70, 50);

			jbtnCommit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent ae) {
					String name = jtfInput.getText();

					if (!name.equals("")) {

						try {
							getConnection(name);
						} catch (SQLException se) {
							se.printStackTrace();
						}
					} else {
						JOptionPane.showMessageDialog(null, "공백은 입력할 수 없습니다.");
					}
				}
			});

			add(jlblName);
			add(jtfInput);
			add(jbtnCommit);

			setSize(400, 400);
			setVisible(true);

			setDefaultCloseOperation(EXIT_ON_CLOSE);
		} // Work

		public void getConnection(String name) throws SQLException {


			// 1. Connection 얻기
			String url = "jdbc:mysql://localhost:3306/jdbc";
			String id = "scott";
			String pass = "tiger";
			Connection con = null;
			Statement stmt = null;

			try {
				con = DriverManager.getConnection(url, id, pass);
				System.out.println("DB연결성공 : " + con);
				// 2. 쿼리문 생성객체 얻기
				stmt = con.createStatement();

				// 3. 쿼리문 실행 후 결과 얻기

				String insertQuery = "insert into test(name) values('" + name + "')";
				int cnt = stmt.executeUpdate(insertQuery);
				System.out.println(insertQuery + "로 " + cnt + "건이 추가 되었습니다.");

			} finally {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
			} // end finally
		}

		public static void main(String[] args) {

			new InsertStatement();

		} // main

	} // class

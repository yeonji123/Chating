import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.View;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Label;

public class SixTeam {
   Login loginInfo;
   private JFrame frame;
   private JTextField textField;
   String getText; // 입력 받은 내용
   
   public ArrayList<String> nameList = new ArrayList<>();
   String[] chatList;
   String nickName;
   Socket socket;
  
   static JTextArea textArea;
   /**
    * Launch the application.
    */

   // 자동 클릭 기능
   public void focus1() {
      frame.addWindowListener(new WindowAdapter() {
         public void windowOpened(WindowEvent e) {
            textField.requestFocus();
         }
      });
   }

   
   public void sixteammain(String nickName, Socket socket) {
      this.nickName = nickName;
      this.socket = socket;

      initialize();
      frame.setVisible(true);
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
//               SixTeam window = new SixTeam();
//               window.frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
   }

   /**
    * Create the application.
    */
   public SixTeam() {
      nickName = new String();
      socket = new Socket();
   }

   /**
    * Initialize the contents of the frame.
    */
   private void initialize() {
	  
      frame = new JFrame();
      frame.setBounds(100, 100, 700, 700);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.getContentPane().setLayout(null);
      focus1();

      //입력 내용 textField
      textField = new JTextField();
      textField.setBounds(22, 604, 513, 49);
      frame.getContentPane().add(textField);
      textField.setColumns(10);
      textField.addKeyListener(new KeyListener() {
         public void keyPressed(KeyEvent e) {
             int key = e.getKeyCode();
             if(key ==KeyEvent.VK_ENTER) {
                textArea.append(textField.getText()+"\n");
                textField.setText("");
             
             }
          }

      @Override
      public void keyTyped(KeyEvent e) {}
      @Override
      public void keyReleased(KeyEvent e) {}

            });
     
      // 채팅 목록창
      textArea = new JTextArea();
      textArea.setBounds(22, 79, 433, 443);
      frame.getContentPane().add(textArea);
      
      // 채팅 목록 스크롤
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(32, 140, 410, 375);
      frame.getContentPane().add(scrollPane);
      scrollPane.setViewportView(textArea);

      JButton btnNewButton = new JButton("😑");
      btnNewButton.setFont(btnNewButton.getFont().deriveFont(20.0f));
      btnNewButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo1 = textField.getText();
            textField.setText(emo1 + "😑");
            textField.requestFocus();
         }
      });

      btnNewButton.setBounds(22, 544, 116, 50);
      frame.getContentPane().add(btnNewButton);

      JButton btnNewButton_1_1 = new JButton("😡");
      btnNewButton_1_1.setFont(btnNewButton_1_1.getFont().deriveFont(20.0f));
      btnNewButton_1_1.setBounds(278, 544, 116, 50);
      btnNewButton_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo2 = textField.getText();
            textField.setText(emo2 + "😡");
            textField.requestFocus();
         }
      });
      frame.getContentPane().add(btnNewButton_1_1);

      JButton btnNewButton_1_1_1 = new JButton("😥");
      btnNewButton_1_1_1.setFont(btnNewButton_1_1_1.getFont().deriveFont(20.0f));
      btnNewButton_1_1_1.setBounds(418, 544, 116, 50);
      btnNewButton_1_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo3 = textField.getText();
            textField.setText(emo3 + "😥");
            textField.requestFocus();
         }
      });
      frame.getContentPane().add(btnNewButton_1_1_1);

      JButton btnNewButton_1_1_1_1 = new JButton("😛");
      btnNewButton_1_1_1_1.setFont(btnNewButton_1_1_1_1.getFont().deriveFont(20.0f));
      btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo4 = textField.getText();
            textField.setText(emo4 + "😛");
            textField.requestFocus();
         }
      });
      btnNewButton_1_1_1_1.setBounds(546, 544, 116, 50);
      frame.getContentPane().add(btnNewButton_1_1_1_1);

      JButton btnNewButton_1 = new JButton("😄");
      btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(20.0f));
      btnNewButton_1.setBounds(150, 544, 116, 50);
      btnNewButton_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            String emo2 = textField.getText();
            textField.setText(emo2 + "😄");
            textField.requestFocus();
         }
      });
      frame.getContentPane().add(btnNewButton_1);
      // 입력 버튼
      JButton btnNewButton_1_1_1_1_1 = new JButton("입력");
      btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            getText = textField.getText();
            textArea.append(getText + "\n");
            
            textField.setText("");

            // 자동 포커스 주기
            textField.requestFocus();
            
         }
      });

      btnNewButton_1_1_1_1_1.setBounds(546, 604, 116, 50);
      frame.getContentPane().add(btnNewButton_1_1_1_1_1);

//      JLabel lblNewLabel = new JLabel("채팅방 이름");
//      lblNewLabel.setBackground(new Color(255, 51, 255));
//      lblNewLabel.setBounds(12, 7, 124, 62);
//      frame.getContentPane().add(lblNewLabel);

      // 방 나가기 ( 퇴장 )
      JButton btnNewButton_1_1_1_1_2 = new JButton("퇴장");
      btnNewButton_1_1_1_1_2.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            frame.dispose(); // frame 닫기
         }
      });
      btnNewButton_1_1_1_1_2.setBounds(558, 13, 116, 50);
      frame.getContentPane().add(btnNewButton_1_1_1_1_2);

      // 채팅방 이름 : ip 주소
      JLabel label = new JLabel("채팅방 :" + Login.ip);
      label.setBounds(40, 10, 250, 62);
      label.setFont(label.getFont().deriveFont(20.0f));
      frame.getContentPane().add(label);

      // 레이블
      JLabel lblNewLabel_1 = new JLabel("참가자 리스트");
      lblNewLabel_1.setBackground(new Color(255, 51, 255));
      lblNewLabel_1.setBounds(538, 72, 124, 62);
      frame.getContentPane().add(lblNewLabel_1);

      // 참가자 리스트를 받아 해당 nickName 값들을 아이템으로 이용한다.
      // 완성된 리스트를 가져와서 item에 넣어준다.

      // 참가자 리스트 표시
//      nameList.add(nickName);

//      for (String nickName : PerClinetThread.clientInfo.keySet()) {
//         nameList.add(nickName);
//      }

      System.out.println("나 닉네임: " + nickName);
      nameList.add(nickName);

      
      chatList = new String[nameList.size()];
      for (int i = 0; i < nameList.size(); i++) {
         chatList[i] = nameList.get(i);
      }

      chatList = new String[nameList.size()];
      for (int i = 0; i < nameList.size(); i++) {
         System.out.println("나 sixTeam 야");
         chatList[i] = nameList.get(i);
      }

      JList list2 = new JList(chatList);
      list2.setBounds(485, 140, 171, 375);
      frame.getContentPane().add(list2);

      list2.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            JList list = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {
               // 더블 클릭한 곳 인덱스 저장.
               int index = list.locationToIndex(evt.getPoint());
               System.out.println(index);
//                  SixTeam_Unicast su = new SixTeam_Unicast(fruits[index], fruits[index].getValue);
               //SixTeam_Unicast su = new SixTeam_Unicast(chatList[index]);
               //su.sixteammain2();

               // 더블클릭시, 해당 인덱스의 jlist가 가지고 있는 값을 가져온다.(닉네임, 그 닉네임이 가지고 있는 소켓)
               // 그리고, 새로운 창이 떠서 새로운 채팅을 시작한다.
               // 유니캐스팅을 할 수 있는 Thread 두 개, 새로운 클라이언트, 새로운 서버 생성하기
               // UnicastSender, UnicastReceiver, UnicastClient, UnicastServer
            }
         }
      });
      frame.setVisible(true);
      
      
      
      
   }
}
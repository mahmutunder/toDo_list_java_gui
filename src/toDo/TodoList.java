package toDo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class TodoList extends JFrame {

    private List<String> tasks = new ArrayList<>();
    private JButton delete;
    private JList<String> taskList;
    private JTextField taskInput;

    private Image icon;

    public TodoList(){
        super("To do list");
        setLayout(new FlowLayout());
        taskInput=new JTextField(20);
        JButton button= new JButton("Add");
        delete= new JButton("Delete");
        taskList = new JList<>();
        taskList.setModel(new DefaultListModel<>());
        JScrollPane scrollPane= new JScrollPane(taskList);
        scrollPane.setPreferredSize(new Dimension(250,300));
        getContentPane().setBackground(Color.black);
        icon= new ImageIcon("logo-top.png").getImage();
        setIconImage(icon);
        setResizable(false);
        setLocation(500,300);

        setDefaultCloseOperation(3);

        button.addActionListener(e -> {
            String task=taskInput.getText();

            tasks.add(task);
            ((DefaultListModel<String>)taskList.getModel()).addElement(task);
            taskInput.setText("");
            JOptionPane.showMessageDialog(null,"To delete item, go over text, select item and delete");
        });

        delete.addActionListener(e-> {

                int selectedIndex=taskList.getSelectedIndex();
                if (selectedIndex !=-1){
                    tasks.remove(selectedIndex);
                    ((DefaultListModel<String>)taskList.getModel()).remove(selectedIndex);
                }

        });

        add(taskInput);
        add(button);
        add(delete);
        add(scrollPane);

        pack();setDefaultCloseOperation(3);
        setVisible(true);



    }

    public static void main(String[] args) {
        new TodoList();
    }

}

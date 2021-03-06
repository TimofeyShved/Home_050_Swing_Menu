package com.Swing;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static JFrame jFrame = getFrame(); // наша форма
    static JPanel jPanel = new JPanel(); // наша панель

    public static void main(String[] args) {
        jFrame.add(jPanel); // добавляем панель на форму

        JMenuBar jMenuBar = new JMenuBar(); // создание основного меню

        JMenu file = new JMenu("File"); // создаем вкладки
        JMenu edit = new JMenu("Edit");
        jMenuBar.add(file); // добавляем в основное меню
        jMenuBar.add(edit); // добавляем вторую вкладку в основное меню и называем её Edit

        file.add(new JMenuItem("Open", 'o'));  // добавляем кнопки
        JMenuItem save = file.add(new JMenuItem("Save", 's')); // создаем подпункт меню и связываем её с добавлением кнопки в меню
        save.setEnabled(false); // делаем её не активной
        file.addSeparator(); // добавляем разделитель

        JMenuItem exit = file.add(new JMenuItem("Exit")); // создаем подпункт меню и связываем её с добавлением кнопки в меню
        exit.addActionListener(new ActionListener() { // добавляем к ней действие
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // действие "выход из программы"
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl e")); // горячие клавишы

        // переходим на 2 вкладку и тоже создаем различные кнопки в ней
        edit.add(new JMenuItem("Cut"));
        edit.add(new JMenuItem("Copy"));
        JMenu option = new JMenu("Option"); // вложенное меню
        edit.add(option);
        option.add("one");
        option.add("two");

        edit.add(new JCheckBoxMenuItem("checed")); // создаем CheckBox

        // создаем RadioButton
        ButtonGroup buttonGroup = new ButtonGroup();
        JRadioButtonMenuItem but1 = new JRadioButtonMenuItem("Button 1"); // создаем к ней кнопки
        JRadioButtonMenuItem but2 = new JRadioButtonMenuItem("Button 2");
        JRadioButtonMenuItem but3 = new JRadioButtonMenuItem("Button 3");
        buttonGroup.add(but1); // объединяем их в одну группу
        buttonGroup.add(but2);
        buttonGroup.add(but3);
        edit.add(but1); // добавляем наши кнопки в пункт меню edit
        edit.add(but2);
        edit.add(but3);

        jFrame.setJMenuBar(jMenuBar); // добавление меню на наш фрейм(окно/программу)
        jFrame.revalidate(); // обновить прорисовку компонентов
    }

    static JFrame getFrame(){
        JFrame jFrame = new JFrame(); // создается форма
        jFrame.setVisible(true); // влючаем видимость
        jFrame.setBounds(750,250,300,300); // размеры
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // выход
        return jFrame;
    }
}

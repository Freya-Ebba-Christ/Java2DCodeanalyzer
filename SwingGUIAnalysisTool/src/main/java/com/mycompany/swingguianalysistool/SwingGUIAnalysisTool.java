/*
                   GNU LESSER GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.


  This version of the GNU Lesser General Public License incorporates
the terms and conditions of version 3 of the GNU General Public
License, supplemented by the additional permissions listed below.

  0. Additional Definitions.

  As used herein, "this License" refers to version 3 of the GNU Lesser
General Public License, and the "GNU GPL" refers to version 3 of the GNU
General Public License.

  "The Library" refers to a covered work governed by this License,
other than an Application or a Combined Work as defined below.

  An "Application" is any work that makes use of an interface provided
by the Library, but which is not otherwise based on the Library.
Defining a subclass of a class defined by the Library is deemed a mode
of using an interface provided by the Library.

  A "Combined Work" is a work produced by combining or linking an
Application with the Library.  The particular version of the Library
with which the Combined Work was made is also called the "Linked
Version".

  The "Minimal Corresponding Source" for a Combined Work means the
Corresponding Source for the Combined Work, excluding any source code
for portions of the Combined Work that, considered in isolation, are
based on the Application, and not on the Linked Version.

  The "Corresponding Application Code" for a Combined Work means the
object code and/or source code for the Application, including any data
and utility programs needed for reproducing the Combined Work from the
Application, but excluding the System Libraries of the Combined Work.

  1. Exception to Section 3 of the GNU GPL.

  You may convey a covered work under sections 3 and 4 of this License
without being bound by section 3 of the GNU GPL.

  2. Conveying Modified Versions.

  If you modify a copy of the Library, and, in your modifications, a
facility refers to a function or data to be supplied by an Application
that uses the facility (other than as an argument passed when the
facility is invoked), then you may convey a copy of the modified
version:

   a) under this License, provided that you make a good faith effort to
   ensure that, in the event an Application does not supply the
   function or data, the facility still operates, and performs
   whatever part of its purpose remains meaningful, or

   b) under the GNU GPL, with none of the additional permissions of
   this License applicable to that copy.

  3. Object Code Incorporating Material from Library Header Files.

  The object code form of an Application may incorporate material from
a header file that is part of the Library.  You may convey such object
code under terms of your choice, provided that, if the incorporated
material is not limited to numerical parameters, data structure
layouts and accessors, or small macros, inline functions and templates
(ten or fewer lines in length), you do both of the following:

   a) Give prominent notice with each copy of the object code that the
   Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the object code with a copy of the GNU GPL and this license
   document.

  4. Combined Works.

  You may convey a Combined Work under terms of your choice that,
taken together, effectively do not restrict modification of the
portions of the Library contained in the Combined Work and reverse
engineering for debugging such modifications, if you also do each of
the following:

   a) Give prominent notice with each copy of the Combined Work that
   the Library is used in it and that the Library and its use are
   covered by this License.

   b) Accompany the Combined Work with a copy of the GNU GPL and this license
   document.

   c) For a Combined Work that displays copyright notices during
   execution, include the copyright notice for the Library among
   these notices, as well as a reference directing the user to the
   copies of the GNU GPL and this license document.

   d) Do one of the following:

       0) Convey the Minimal Corresponding Source under the terms of this
       License, and the Corresponding Application Code in a form
       suitable for, and under terms that permit, the user to
       recombine or relink the Application with a modified version of
       the Linked Version to produce a modified Combined Work, in the
       manner specified by section 6 of the GNU GPL for conveying
       Corresponding Source.

       1) Use a suitable shared library mechanism for linking with the
       Library.  A suitable mechanism is one that (a) uses at run time
       a copy of the Library already present on the user's computer
       system, and (b) will operate properly with a modified version
       of the Library that is interface-compatible with the Linked
       Version.

   e) Provide Installation Information, but only if you would otherwise
   be required to provide such information under section 6 of the
   GNU GPL, and only to the extent that such information is
   necessary to install and execute a modified version of the
   Combined Work produced by recombining or relinking the
   Application with a modified version of the Linked Version. (If
   you use option 4d0, the Installation Information must accompany
   the Minimal Corresponding Source and Corresponding Application
   Code. If you use option 4d1, you must provide the Installation
   Information in the manner specified by section 6 of the GNU GPL
   for conveying Corresponding Source.)

  5. Combined Libraries.

  You may place library facilities that are a work based on the
Library side by side in a single library together with other library
facilities that are not Applications and are not covered by this
License, and convey such a combined library under terms of your
choice, if you do both of the following:

   a) Accompany the combined library with a copy of the same work based
   on the Library, uncombined with any other library facilities,
   conveyed under the terms of this License.

   b) Give prominent notice with the combined library that part of it
   is a work based on the Library, and explaining where to find the
   accompanying uncombined form of the same work.

  6. Revised Versions of the GNU Lesser General Public License.

  The Free Software Foundation may publish revised and/or new versions
of the GNU Lesser General Public License from time to time. Such new
versions will be similar in spirit to the present version, but may
differ in detail to address new problems or concerns.

  Each version is given a distinguishing version number. If the
Library as you received it specifies that a certain numbered version
of the GNU Lesser General Public License "or any later version"
applies to it, you have the option of following the terms and
conditions either of that published version or of any later version
published by the Free Software Foundation. If the Library as you
received it does not specify a version number of the GNU Lesser
General Public License, you may choose any version of the GNU Lesser
General Public License ever published by the Free Software Foundation.

  If the Library as you received it specifies that a proxy can decide
whether future versions of the GNU Lesser General Public License shall
apply, that proxy's public statement of acceptance of any version is
permanent authorization for you to choose that version for the
Library.

 */
/**
 * Copyright (C) <2024>  <Freya Ebba Christ>
 * @author Freya Ebba Christ
 */

package com.mycompany.swingguianalysistool;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;

interface ListenerVisitor {

    void visit(Object listener, String componentName);

    void visitProperties(String componentName, Map<String, String> properties);
}

interface ComponentVisitor {

    void visit(Component component, String parentName);
}

interface ContainerVisitor extends ComponentVisitor {

    void visitContainer(Container container, String parentName);
}

class ComponentInfo {

    List<String> listeners = new ArrayList<>();
    Map<String, String> properties = new HashMap<>();
}

class NullListenerVisitor implements ListenerVisitor {

    @Override
    public void visit(Object listener, String componentName) {
        // No operation
    }

    @Override
    public void visitProperties(String componentName, Map<String, String> properties) {
        // No operation
    }
}

class GenericListenerVisitor implements ListenerVisitor {

    private final Map<String, ComponentInfo> componentInfoMap = new HashMap<>();
    private final ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

    @Override
    public void visit(Object listener, String componentName) {
        componentInfoMap.computeIfAbsent(componentName, k -> new ComponentInfo()).listeners.add(listener.getClass().getSimpleName());
    }

    @Override
    public void visitProperties(String componentName, Map<String, String> properties) {
        componentInfoMap.computeIfAbsent(componentName, k -> new ComponentInfo()).properties.putAll(properties);
        exportComponentToYAML(componentName, componentInfoMap.get(componentName));
    }

    private void exportComponentToYAML(String componentName, ComponentInfo componentInfo) {
        String fileName = componentName.replaceAll("[^a-zA-Z0-9\\.\\-]", "_") + ".yaml";
        try {
            yamlMapper.writeValue(new File(fileName), Map.of(componentName, componentInfo));
            System.out.println("Exported YAML for " + componentName);
        } catch (IOException e) {
        }
    }
}

class GenericComponentVisitor implements ContainerVisitor {

    private final ListenerVisitor listenerVisitor;
    private final Set<Integer> visitedComponents = new HashSet<>();

    public GenericComponentVisitor(ListenerVisitor listenerVisitor) {
        this.listenerVisitor = listenerVisitor != null ? listenerVisitor : new NullListenerVisitor();
    }

    @Override
    public void visit(Component component, String parentName) {
        int componentId = System.identityHashCode(component);
        if (visitedComponents.contains(componentId)) {
            System.out.println("Cycle detected, skipping component: " + component.getClass().getSimpleName() + "@" + componentId);
            return;
        }

        visitedComponents.add(componentId);

        String componentName = parentName + ">" + component.getClass().getSimpleName() + "@" + componentId;
        ComponentListenerExtractor.extractListeners(component, componentName, listenerVisitor);
        extractProperties(component, componentName);

        if (component instanceof Container container) {
            visitContainer(container, componentName);
        }
    }

    @Override
    public void visitContainer(Container container, String parentName) {
        for (Component child : container.getComponents()) {
            visit(child, parentName);
        }
    }

    private void extractProperties(Component component, String componentName) {
        Map<String, String> properties = new HashMap<>();
        Method[] methods = component.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0 && !method.getName().equals("getClass")) {
                try {
                    Object value = method.invoke(component);
                    String propertyName = method.getName().replaceFirst("get", "");
                    propertyName = Character.toLowerCase(propertyName.charAt(0)) + propertyName.substring(1);
                    properties.put(propertyName, String.valueOf(value));
                } catch (IllegalAccessException | InvocationTargetException ignored) {
                }
            }
        }
        listenerVisitor.visitProperties(componentName, properties);
    }
}

class ComponentListenerExtractor {

    public static void extractListeners(Component component, String componentName, ListenerVisitor listenerVisitor) {
        Method[] methods = component.getClass().getMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getName().endsWith("Listeners")) {
                try {
                    Object[] listeners = (Object[]) method.invoke(component);
                    for (Object listener : listeners) {
                        listenerVisitor.visit(listener, componentName);
                    }
                } catch (IllegalAccessException | InvocationTargetException ignored) {
                }
            }
        }
    }
}

public class SwingGUIAnalysisTool {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new Calculator(); // Corrected instantiation of the Calculator class

            GenericListenerVisitor listenerVisitor = new GenericListenerVisitor();
            GenericComponentVisitor componentVisitor = new GenericComponentVisitor(listenerVisitor);
            componentVisitor.visit(frame, "Frame");
        });
    }

    static final class Calculator extends JFrame {

        private static final String NUMBER_PROPERTY = "NUMBER_PROPERTY";
        private static final String OPERATOR_PROPERTY = "OPERATOR_PROPERTY";
        private static final String FIRST = "FIRST";
        private static final String VALID = "VALID";

        // These would be much better if placed in an enum,
        // but enums are only available starting in Java 5.
        // Code using them isn't back portable.
        private static interface Operator {

            static final int EQUALS = 0;
            static final int PLUS = 1;
            static final int MINUS = 2;
            static final int MULTIPLY = 3;
            static final int DIVIDE = 4;
        }

        private String status;
        private int previousOperation;
        private double lastValue;
        private final JTextArea lcdDisplay;
        private final JLabel errorDisplay;

        public static void main(String[] args) {
            // Remember, all swing components must be accessed from
            // the event dispatch thread.
            SwingUtilities.invokeLater(() -> {
                Calculator calc = new Calculator();
                calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                calc.setVisible(true);
            });
        }

        /**
         * this is just some example I once found on the web The code is not
         * mine and will be remove in the near future
         */
        public Calculator() {
            super("Calculator");
            this.numberListener = (ActionEvent e) -> {
                JComponent source = (JComponent) e.getSource();
                Integer number = (Integer) source.getClientProperty(NUMBER_PROPERTY);
                if (number == null) {
                    throw new IllegalStateException("No NUMBER_PROPERTY on component");
                }
                
                numberButtonPressed(number.intValue());
            };

            JPanel mainPanel = new JPanel(new BorderLayout());
            JPanel numberPanel = buildNumberPanel();
            JPanel operatorPanel = buildOperatorPanel();
            JPanel clearPanel = buildClearPanel();
            lcdDisplay = new JTextArea();
            lcdDisplay.setFont(new Font("Dialog", Font.BOLD, 18));
            mainPanel.add(clearPanel, BorderLayout.SOUTH);
            mainPanel.add(numberPanel, BorderLayout.CENTER);
            mainPanel.add(operatorPanel, BorderLayout.EAST);
            mainPanel.add(lcdDisplay, BorderLayout.NORTH);

            errorDisplay = new JLabel(" ");
            errorDisplay.setFont(new Font("Dialog", Font.BOLD, 12));

            getContentPane().setLayout(new BorderLayout());
            getContentPane().add(mainPanel, BorderLayout.CENTER);
            getContentPane().add(errorDisplay, BorderLayout.SOUTH);

            pack();
            resetState();
        }

        private final ActionListener numberListener;

        private final ActionListener decimalListener = (ActionEvent e) -> {
            decimalButtonPressed();
        };

        private final ActionListener operatorListener = (ActionEvent e) -> {
            JComponent source = (JComponent) e.getSource();
            Integer opCode = (Integer) source.getClientProperty(OPERATOR_PROPERTY);
            if (opCode == null) {
                throw new IllegalStateException("No OPERATOR_PROPERTY on component");
            }
            
            operatorButtonPressed(opCode);
        };

        private final ActionListener clearListener = (ActionEvent e) -> {
            resetState();
        };

        private JButton buildNumberButton(int number) {
            JButton button = new JButton(Integer.toString(number));
            button.putClientProperty(NUMBER_PROPERTY, number);
            button.addActionListener(numberListener);
            return button;
        }

        private JButton buildOperatorButton(String symbol, int opType) {
            JButton plus = new JButton(symbol);
            plus.putClientProperty(OPERATOR_PROPERTY, opType);
            plus.addActionListener(operatorListener);
            return plus;
        }

        public JPanel buildNumberPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 3));

            panel.add(buildNumberButton(7));
            panel.add(buildNumberButton(8));
            panel.add(buildNumberButton(9));
            panel.add(buildNumberButton(4));
            panel.add(buildNumberButton(5));
            panel.add(buildNumberButton(6));
            panel.add(buildNumberButton(1));
            panel.add(buildNumberButton(2));
            panel.add(buildNumberButton(3));

            JButton buttonDec = new JButton(".");
            buttonDec.addActionListener(decimalListener);
            panel.add(buttonDec);

            panel.add(buildNumberButton(0));

            // Exit button is to close the calculator and terminate the program.
            JButton buttonExit = new JButton("EXIT");
            buttonExit.setMnemonic(KeyEvent.VK_C);
            buttonExit.addActionListener((ActionEvent e) -> {
                System.exit(0);
            });
            panel.add(buttonExit);
            return panel;

        }

        public JPanel buildOperatorPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(4, 1));

            panel.add(buildOperatorButton("+", Operator.PLUS));
            panel.add(buildOperatorButton("-", Operator.MINUS));
            panel.add(buildOperatorButton("*", Operator.MULTIPLY));
            panel.add(buildOperatorButton("/", Operator.DIVIDE));
            return panel;
        }

        public JPanel buildClearPanel() {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 3));

            JButton clear = new JButton("C");
            clear.addActionListener(clearListener);
            panel.add(clear);

            JButton CEntry = new JButton("CE");
            CEntry.addActionListener(clearListener);
            panel.add(CEntry);

            panel.add(buildOperatorButton("=", Operator.EQUALS));

            return panel;
        }

        public void numberButtonPressed(int i) {
            String displayText = lcdDisplay.getText();
            String valueString = Integer.toString(i);

            if (("0".equals(displayText)) || (FIRST.equals(status))) {
                displayText = "";
            }

            int maxLength = (displayText.contains(".")) ? 21 : 20;
            if (displayText.length() + valueString.length() <= maxLength) {
                displayText += valueString;
                clearError();
            } else {
                setError("Reached the 20 digit max");
            }

            lcdDisplay.setText(displayText);
            status = VALID;
        }

        public void operatorButtonPressed(int newOperation) {
            Double displayValue = Double.valueOf(lcdDisplay.getText());

//        if(newOperation == Operator.EQUALS && previousOperation != //Operator.EQUALS){
//            operatorButtonPressed(previousOperation);
//        } else {
            switch (previousOperation) {
                case Operator.PLUS -> {
                    displayValue = lastValue + displayValue;
                    commitOperation(newOperation, displayValue);
                }
                case Operator.MINUS -> {
                    displayValue = lastValue - displayValue;
                    commitOperation(newOperation, displayValue);
                }
                case Operator.MULTIPLY -> {
                    displayValue = lastValue * displayValue;
                    commitOperation(newOperation, displayValue);
                }
                case Operator.DIVIDE -> {
                    if (displayValue == 0) {
                        setError("ERROR: Division by Zero");
                    } else {
                        displayValue = lastValue / displayValue;
                        commitOperation(newOperation, displayValue);
                    }
                }
                case Operator.EQUALS -> commitOperation(newOperation, displayValue);
//            }
            }
        }

        public void decimalButtonPressed() {
            String displayText = lcdDisplay.getText();
            if (FIRST.equals(status)) {
                displayText = "0";
            }

            if (!displayText.contains(".")) {
                displayText = displayText + ".";
            }
            lcdDisplay.setText(displayText);
            status = VALID;
        }

        private void setError(String errorMessage) {
            if (errorMessage.trim().equals("")) {
                errorMessage = " ";
            }
            errorDisplay.setText(errorMessage);
        }

        private void clearError() {
            status = FIRST;
            errorDisplay.setText(" ");
        }

        private void commitOperation(int operation, double result) {
            status = FIRST;
            lastValue = result;
            previousOperation = operation;
            lcdDisplay.setText(String.valueOf(result));
        }

        /**
         * Resets the program state.
         */
        void resetState() {
            clearError();
            lastValue = 0;
            previousOperation = Operator.EQUALS;

            lcdDisplay.setText("0");
        }
    }
}


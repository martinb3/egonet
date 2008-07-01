package com.endlessloopsoftware.ego.client.graph;

import javax.swing.*;
import javax.swing.table.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.*;
import org.jdesktop.layout.GroupLayout;

import org.egonet.util.listbuilder.Selection;
import org.egonet.util.table.*;

import com.endlessloopsoftware.ego.*;
import com.endlessloopsoftware.ego.client.EgoClient;

public class NodeColorPanel extends JPanel {

	private JLabel questionLabel;

	private JComboBox questionCombo;

	ColorChooserEditor colorChooser;

	private JTable table;

	private GroupLayout layout;

	private GraphRenderer graphRenderer;

	private JButton applyButton;

	List<Selection> selectionList = new ArrayList<Selection>();

	public NodeColorPanel(GraphRenderer renderer) {
		this.graphRenderer = renderer;
		layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutocreateGaps(true);
		layout.setAutocreateContainerGaps(true);
		createComponents();
	}

	private void createComponents() {

		questionLabel = new JLabel("Choose question to shape");
		questionLabel.setVisible(true);

		// create questionCombo
		List<Question> qList = new ArrayList<Question>();
		Study study = EgoClient.interview.getStudy();
		QuestionList questionList = study.getQuestions();
		Map<Long, Question> questionMap = questionList.getQuestionMap();
		for (Long key : questionMap.keySet()) {
			Question currentQuestion = questionMap.get(key);
			int questionType = currentQuestion.questionType;
			if (questionType == Question.ALTER_QUESTION) {
				// populate the list box with only questions that have choices
				// as answers
				if (currentQuestion.answerType == Question.CATEGORICAL
						|| currentQuestion.answerType == Question.TEXT)
					qList.add(currentQuestion);
			}
		}
		questionCombo = new JComboBox(qList.toArray());
		questionCombo.setVisible(true);
		questionCombo.setEnabled(true);
		questionCombo.setPreferredSize(new Dimension(20, 20));
		questionCombo.setMaximumSize(new Dimension(20, 30));
		questionCombo.setAutoscrolls(true);

		questionCombo.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					createTable();
					drawPanel();
				}
			}
		});

		// create apply button
		applyButton = new JButton("Apply Colors");
		applyButton.setVisible(true);
		applyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNodeColor();
			}
		});

		createTable();
		drawPanel();

	}

	private Object[][] getRowData() {
		Question question;
		question = (Question) questionCombo.getSelectedItem();

		// System.out.println("Question examining:" + question.UniqueId);

		if (question.answerType == Question.CATEGORICAL) {
			int noOfRows = question.selections.length;
			Object[][] rowData = new Object[noOfRows][2];
			/* change the list of selections based on the selected question */
			if (!selectionList.isEmpty()) {
				selectionList.removeAll(selectionList);
			}
			for (Selection selection : question.selections) {
				selectionList.add(selection);
			}
			for (int i = 0; i < noOfRows; i++) {
				rowData[i][0] = selectionList.get(i);
			}
			int noOfColors = question.selections.length;
			Random rand = new Random();
			for (int i = 0; i < noOfColors; i++) {
				int red = rand.nextInt(255);
				int green = rand.nextInt(255);
				int blue = rand.nextInt(255);
				Color color = new Color(red, green, blue);
				rowData[i][1] = color;
			}
			return rowData;

		} else {
			// System.out.println("Populating text answers!!!");
			if (!selectionList.isEmpty()) {
				selectionList.removeAll(selectionList);
			}
			Answer[] answers = EgoClient.interview.get_answers();
			for (int i = 0; i < answers.length; i++) {
				// System.out.println("Question examining:"
				// + answers[i].questionId + "," + question.UniqueId);
				if (answers[i].questionId.equals(question.UniqueId)) {

					if (answers[i].string == null
							|| isPresentInSelectionList(answers[i].string)) {
						continue;
					}
					Selection selection = new Selection();
					selection.setString(answers[i].string);
					// System.out.println("Selection:" + selection);
					selectionList.add(selection);
				}

			}
			Object[][] rowData = new Object[selectionList.size()][2];
			for (int i = 0; i < selectionList.size(); i++) {
				rowData[i][0] = selectionList.get(i);
			}
			int noOfColors = selectionList.size();
			Random rand = new Random();
			for (int i = 0; i < noOfColors; i++) {
				int red = rand.nextInt(255);
				int green = rand.nextInt(255);
				int blue = rand.nextInt(255);
				Color color = new Color(red, green, blue);
				rowData[i][1] = color;
			}
			return rowData;
		}
	}

	private boolean isPresentInSelectionList(String str) {
		for (int i = 0; i < selectionList.size(); i++) {
			if (selectionList.get(i).getString().equals(str))
				return true;
		}
		return false;
	}

	private void createTable() {

		Object[][] rowData = getRowData();

		// populate the colors

		table = new JTable(new PropertyTableModel(rowData));
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setRowHeight(25);
		table.setVisible(true);
		table.setBorder(BorderFactory.createCompoundBorder(BorderFactory
				.createLineBorder(Color.black), getBorder()));

		TableColumnModel columnModel = table.getColumnModel();
		LabelRenderer selectionRenderer = new LabelRenderer();
		columnModel.getColumn(0).setCellRenderer(selectionRenderer);

		TableCellEditor colorEditor = new ColorEditor();
		columnModel.getColumn(1).setCellEditor(colorEditor);
		ColorRenderer colorButtonRenderer = new ColorRenderer(true);
		columnModel.getColumn(1).setCellRenderer(colorButtonRenderer);

		columnModel.getColumn(0).setMaxWidth(200);
		columnModel.getColumn(1).setMaxWidth(150);
	}

	private void updateNodeColor() {
		Question question = (Question) questionCombo.getSelectedItem();
		System.out.println("Question combo" +question.UniqueId);
		
		if (question.answerType == Question.CATEGORICAL) {
			for (int i = 0; i < question.selections.length; i++) {
				Selection selection = question.selections[i];

				GraphQuestionSelectionPair graphQuestion = new GraphQuestionSelectionPair(question,
						selection, Question.ALTER_QUESTION);
				NodeProperty nodeProperty = new NodeProperty();
				nodeProperty.setColor((Color) table.getValueAt(i, 1));
				nodeProperty.setProperty(NodeProperty.NodePropertyType.Color);
				graphRenderer.addQAsettings(graphQuestion, nodeProperty);
				graphRenderer.updateGraphSettings();
			}
		}else if (question.answerType == Question.TEXT) {
			System.out.println("Applying labels for text questions");
			for (int i =0;i < selectionList.size() ; i++) {
				Selection selection = selectionList.get(i);
				NodeProperty nodeProperty = new NodeProperty();
				nodeProperty.setColor((Color) table.getValueAt(i, 1));
				nodeProperty.setProperty(NodeProperty.NodePropertyType.Color);
				GraphQuestionSelectionPair graphQuestion = new GraphQuestionSelectionPair(question,
						selection, Question.ALTER_QUESTION);
				graphRenderer.addQAsettings(graphQuestion, nodeProperty);
				graphRenderer.updateGraphSettings();
			}
		}
		// graphRenderer.getVv().repaint();
	}

	private void drawPanel() {
		this.removeAll();

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.add(layout.createParallelGroup().add(questionLabel).add(
				questionCombo).add(table.getTableHeader()).add(table).add(
				applyButton));

		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		vGroup.add(layout.createParallelGroup(GroupLayout.BASELINE).add(
				questionLabel));
		vGroup.add(layout.createParallelGroup(GroupLayout.BASELINE).add(
				questionCombo));
		vGroup.add(layout.createParallelGroup(GroupLayout.BASELINE).add(
				table.getTableHeader()));
		vGroup.add(layout.createParallelGroup(GroupLayout.BASELINE).add(table));
		vGroup.add(layout.createParallelGroup(GroupLayout.BASELINE).add(
				applyButton));

		layout.setVerticalGroup(vGroup);
	}
}

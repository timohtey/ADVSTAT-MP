import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraphPanel extends JPanel {
	private DefaultCategoryDataset dataSet;
	private JFreeChart barGraph;
	private CategoryPlot categoryPlot;
	private ChartPanel chartPanel;
	public BarGraphPanel(ArrayList<Double> probabilities, int x1, int x2){
		dataSet = new DefaultCategoryDataset();
		
		int j = x1;
		if(x2 != 0){
			for(int i =0; i<probabilities.size();i++){
				if(probabilities.get(i) <0){
					dataSet.setValue(0, "0", "f("+j+")");
				}
				else dataSet.setValue(probabilities.get(i), "0", "f("+j+")");		
				j++;
			}
		}
		else dataSet.setValue(x1,"0","f("+x1+")");
		
		barGraph = ChartFactory.createBarChart("Numerical Methods", "", "", dataSet, PlotOrientation.VERTICAL, false, true, false);
		categoryPlot = barGraph.getCategoryPlot();
		categoryPlot.setRangeGridlinePaint(Color.BLACK);
		chartPanel = new ChartPanel(barGraph);
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 600, 400);
		this.setVisible(true);
		this.add(chartPanel);
	}
}

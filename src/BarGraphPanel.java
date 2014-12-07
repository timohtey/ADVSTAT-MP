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
	ArrayList<Double> roots = new ArrayList<Double>();
	
	public BarGraphPanel(ArrayList<Double> roots){
		dataSet = new DefaultCategoryDataset();
		int j = 0;
		for(int i = 0; i<roots.size(); i++){
			dataSet.setValue(roots.get(i), "0", ""+j);
			System.out.println(roots.get(i));
			j++;
		};
		
		barGraph = ChartFactory.createLineChart("Numerical Methods", "", "", dataSet, PlotOrientation.VERTICAL, true, true, true);
		categoryPlot = barGraph.getCategoryPlot();
		categoryPlot.setRangeGridlinePaint(Color.BLACK);
		chartPanel = new ChartPanel(barGraph);
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 660, 400);
		this.setVisible(true);
		this.add(chartPanel);
	}
	
	public void setRoots(ArrayList<Double> roots){
		this.roots = roots;
	}
}

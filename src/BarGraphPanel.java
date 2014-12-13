import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarGraphPanel extends JPanel {
	private DefaultCategoryDataset dataSet;
	private DefaultCategoryDataset dataSet2;
	private JFreeChart barGraph;
	private CategoryPlot categoryPlot;
	private ChartPanel chartPanel;
	ArrayList<Double> polyRoots = new ArrayList<Double>();
	ArrayList<Double> roots = new ArrayList<Double>();
	private int dataSetIndex = 0;
	
	public BarGraphPanel(ArrayList<Double> roots, ArrayList<Double> polyRoots){
		dataSet = new DefaultCategoryDataset();
		dataSet2 = new DefaultCategoryDataset();
		int j = 0, h = 0;
		
		for(int i = 0; i<polyRoots.size(); i++){
			dataSet.setValue(polyRoots.get(i), "Polynomial", ""+h);
			dataSet.setValue(roots.get(i), "Roots", ""+j);
			h++;
			j++;
		}
		
		
		barGraph = ChartFactory.createLineChart("Numerical Methods", "", "", dataSet, PlotOrientation.VERTICAL, true, true, true);
		categoryPlot = barGraph.getCategoryPlot();
		categoryPlot.setRangeGridlinePaint(Color.BLACK);
		chartPanel = new ChartPanel(barGraph);
		this.setLayout(new BorderLayout());
		this.setBounds(0, 0, 660, 400);
		this.setVisible(true);
		this.add(chartPanel);
		chartPanel.zoomOutRange(1, 2);;
		chartPanel.restoreAutoBounds();
		
//		if (dataSetIndex < 20) {
//            dataSetIndex++;
//            categoryPlot.setDataset(
//                dataSetIndex, dataSet2);
//            CategoryItemRenderer renderer = categoryPlot.getRenderer();
//            categoryPlot.setRenderer(dataSetIndex, renderer);
//        }
	}
	
	public void setRoots(ArrayList<Double> roots){
		this.roots = roots;
	}
}

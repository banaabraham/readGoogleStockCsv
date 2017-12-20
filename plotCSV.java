import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class plotCSV extends ApplicationFrame{
	
	static getTitle(String dir){
		return dir.split("\\\\")[3].replace(".csv", "");
	}
	
	plotCSV(String dir){
		super(getTitle(dir));
		String title = getTitle(dir);
		readCSV datas = new readCSV(dir);
		ArrayList<Double> close = datas.getClose();
		XYSeries series = new XYSeries(title);
		
		for(int i=0;i<close.size();i++){
			series.add(i,close.get(i));
		}
		
		XYSeriesCollection data = new XYSeriesCollection(series);
		   JFreeChart chart = ChartFactory.createXYLineChart(
		       title,
		       "Waktu", 
		       "Harga", 
		       data,
		       PlotOrientation.VERTICAL,
		       true,
		       true,
		       false
		   );

		   ChartPanel chartPanel = new ChartPanel(chart);
		   chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
		   setContentPane(chartPanel);
		   
		   this.pack();
		   this.setVisible(true);
		   RefineryUtilities.centerFrameOnScreen(this);

		}
	}

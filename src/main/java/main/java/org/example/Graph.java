package main.java.org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

import static main.java.org.example.Form.*;

public class Graph extends JFrame {

    private  XYDataset dataset = createDataset((int)up,(int)down,func_num);
    public JFreeChart chart = createChart(dataset);

    public Graph(int up, int down, int funcNum) {
    }

    private XYDataset createDataset(int up, int down, int func_n) {

        String key = "";
        if (func_n == 1){
            key = "Cos";
        }
        if (func_n == 2){
            key = "Sin";
        }
        if (func_n == 3){
            key = "Tg";
        }
        var series = new XYSeries(key);
        Integration in = new Integration();
        for (int i=down;i<=up; i++){
            double d = Double.parseDouble(in.calc_shell(func_n, down, i, 10));
            series.add(i,d);
        }
        var dataset = new XYSeriesCollection();
        dataset.addSeries(series);

        return dataset;
    }

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Integration Results",
                "Input",
                "Output",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Graph Of Integral With Variable Limits",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }
}

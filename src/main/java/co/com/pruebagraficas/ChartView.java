/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.pruebagraficas;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LinearAxis;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;

/**
 *
 * @author cristian.ordonez
 */
@ManagedBean
public class ChartView implements Serializable {

    private LineChartModel multiAxisModel;
    private OhlcChartModel ohlcChartModel;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private VelasDTO velasDTO;
    private List<VelasDTO> listVelas;

    @EJB
    SpBusinessServiceLocal spBusinessServiceLocal;


    public ChartView() {
        ohlcChartModel = new OhlcChartModel();
        listVelas = new ArrayList<VelasDTO>();
    }

    @PostConstruct
    public void init() {

//        createMultiAxisModel();
        crearGraficoVelas();
    }

    private void createMultiAxisModel() {
        multiAxisModel = new LineChartModel();

        BarChartSeries boys = new BarChartSeries();
        boys.setLabel("Boys");

        boys.set("2004", 120);
        boys.set("2005", 100);
        boys.set("2006", 44);
        boys.set("2007", 150);
        boys.set("2008", 25);
        boys.set("2009", 26);
        boys.set("2010", 28);
        LineChartSeries girls = new LineChartSeries();
        girls.setLabel("Girls");
        girls.setXaxis(AxisType.X2);
        girls.setYaxis(AxisType.Y2);

        girls.set("A", 52);
        girls.set("B", 60);
        girls.set("C", 110);
        girls.set("D", 135);
        girls.set("E", 120);

        multiAxisModel.addSeries(boys);
        multiAxisModel.addSeries(girls);

        multiAxisModel.setTitle("Multi Axis Chart");
        multiAxisModel.setMouseoverHighlight(false);

        multiAxisModel.getAxes().put(AxisType.X, new CategoryAxis("Years"));
        multiAxisModel.getAxes().put(AxisType.X2, new CategoryAxis("Period"));

        Axis yAxis = multiAxisModel.getAxis(AxisType.Y);
        yAxis.setLabel("Birth");
        yAxis.setMin(0);
        yAxis.setMax(200);

        Axis y2Axis = new LinearAxis("Number");
        y2Axis.setMin(0);
        y2Axis.setMax(200);

        multiAxisModel.getAxes().put(AxisType.Y2, y2Axis);
    }

    private void crearGraficoVelas() {
//        ohlcChartModel = new OhlcChartModel();

//        OhlcChartSeries vela = new OhlcChartSeries(1, 1.91526635139091, 6, 0.8, 3.23382938680922);
//        for (int i = 1; i < 13; i++) {
//            ohlcChartModel.add(new OhlcChartSeries(i, Math.random() * 80 + 80, Math.random() * 50 + 110, Math.random() * 20 + 80, Math.random() * 80 + 80));
//        }
//        ohlcChartModel.add(new OhlcChartSeries(1, 1.915266, 6.000000, 0, 3.233829));
//        ohlcChartModel.add(new OhlcChartSeries(2, 0.919097, 6.012000, 0, 1.919097));
//        ohlcChartModel.add(new OhlcChartSeries(3, 0.422935, 6.024024, 0, 1.922935));
//        ohlcChartModel.add(new OhlcChartSeries(4, 1.926781, 6.036072, 0, 0.235235));
//        ohlcChartModel.add(new OhlcChartSeries(5, 1.930635, 6.048144, 0, 0.235706));
//        ohlcChartModel.add(new OhlcChartSeries(6, 0.934496, 6.036072, 0, 1.934496));
//        ohlcChartModel.add(new OhlcChartSeries(7, 5.000000, 6.072361, 0, 0.236649));
//        ohlcChartModel.add(new OhlcChartSeries(8, 1.942242, 6.084506, 0, 0.237123));
//        ohlcChartModel.add(new OhlcChartSeries(9, 1.946126, 6.096675, 0, 0.237597));
//        ohlcChartModel.add(new OhlcChartSeries(10, 1.950018, 6.108868, 0, 0.238072));
//        ohlcChartModel.add(new OhlcChartSeries(11, 1.953918, 6.121086, 0, 0.238548));
//        ohlcChartModel.add(new OhlcChartSeries(12, 1.957826, 6.133328, 0, 0.239025));
        spBusinessServiceLocal.listarValoresVelas();

        ohlcChartModel.setTitle("Candlestick");
        ohlcChartModel.setCandleStick(true);
        ohlcChartModel.getAxis(AxisType.X).setLabel("Sector");
        ohlcChartModel.getAxis(AxisType.Y).setLabel("Index Value");
    }

    public OhlcChartModel getOhlcChartModel() {
        return ohlcChartModel;
    }

    public VelasDTO getVelasDTO() {
        return velasDTO;
    }

    public void setVelasDTO(VelasDTO velasDTO) {
        this.velasDTO = velasDTO;
    }

    public LineChartModel getMultiAxisModel() {
        return multiAxisModel;
    }

}

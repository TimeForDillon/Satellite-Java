package Satelite;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Extracts satellite data from CSV file
 * @author Dillon Welsh
 * @version 0.1
 */
public class DataReader
{
	private File satDataFile;
	private Scanner fileScanner;
	private ArrayList<String> date_and_time;
	// solar panels' voltage is measured in mV
	private ArrayList<Integer> solar_panel_voltage_x;
	private ArrayList<Integer> solar_panel_voltage_y;
	private ArrayList<Integer> solar_panel_voltage_z;
	// total photo current is measured in mA
	private ArrayList<Integer> total_photo_current;
	// battery voltage is measured in mV
	private ArrayList<Integer> battery_voltage;
	// total system current is measured in mA
	private ArrayList<Integer> total_system_current;
	// boost converters temps, battery temps, and solar panel temps are measured in celcius
	private ArrayList<Integer> boost_converter_temp1;
	private ArrayList<Integer> boost_converter_temp2;
	private ArrayList<Integer> boost_converter_temp3;
	private ArrayList<Integer> battery_temp;
	private ArrayList<Double> solar_panel_temp_x_plus;
	private ArrayList<Double> solar_panel_temp_x_minus;
	private ArrayList<Double> solar_panel_temp_y_plus;
	private ArrayList<Double> solar_panel_temp_y_minus;
	// sun sensors are measured in W/m^2
	private ArrayList<Double> sun_sensor_x_plus;
	private ArrayList<Double> sun_sensor_y_plus;
	private ArrayList<Double> sun_sensor_z_plus;
	// 3.3 bus voltage measured in mV
	private ArrayList<Double> three_bus_voltage;
	// 3.3 bus current measured in mA
	private ArrayList<Double> three_bus_current;
	// 5.0 bus voltage measured in mV
	private ArrayList<Double> five_bus_voltage;
	// rf temperature measured in celcius
	private ArrayList<Double> rf_temp;
	// receive current measured in mA
	private ArrayList<Integer> receive_current;
	// rf current 3.3V and 5.0V busses measured in mA
	private ArrayList<Integer> three_rf_current;
	private ArrayList<Integer> five_rf_current;
	// pa device temp measured in celcius
	private ArrayList<Double> pa_device_temp;
	// pa bus current measured in mA
	private ArrayList<Double> pa_bus_current;
	// antenna temps are measured in celcius
	private ArrayList<Double> antenna_temp_zero;
	private ArrayList<Double> antenna_temp_one;
	
	/**
	 * Constructs a DataReader object and initializes all instance variables.
	 */
	public DataReader()
	{
		this.satDataFile = new File("sat_realtime_telemetry.txt");
		this.date_and_time = new ArrayList<String>();
		this.solar_panel_voltage_x = new ArrayList<Integer>();
		this.solar_panel_voltage_y = new ArrayList<Integer>();
		this.solar_panel_voltage_z = new ArrayList<Integer>();
		this.total_photo_current = new ArrayList<Integer>();
		this.battery_voltage = new ArrayList<Integer>();
		this.total_system_current = new ArrayList<Integer>();
		this.boost_converter_temp1 = new ArrayList<Integer>();
		this.boost_converter_temp2 = new ArrayList<Integer>();
		this.boost_converter_temp3 = new ArrayList<Integer>();
		this.battery_temp = new ArrayList<Integer>();
		this.sun_sensor_x_plus = new ArrayList<Double>();
		this.sun_sensor_y_plus = new ArrayList<Double>();
		this.sun_sensor_z_plus = new ArrayList<Double>();
		this.solar_panel_temp_x_plus = new ArrayList<Double>();
		this.solar_panel_temp_x_minus = new ArrayList<Double>();
		this.solar_panel_temp_y_plus = new ArrayList<Double>();
		this.solar_panel_temp_y_minus = new ArrayList<Double>();
		this.three_bus_voltage = new ArrayList<Double>();
		this.three_bus_current = new ArrayList<Double>();
		this.five_bus_voltage = new ArrayList<Double>();
		this.rf_temp = new ArrayList<Double>();
		this.receive_current = new ArrayList<Integer>();
		this.three_rf_current = new ArrayList<Integer>();
		this.five_rf_current = new ArrayList<Integer>();
		this.pa_device_temp = new ArrayList<Double>();
		this.pa_bus_current = new ArrayList<Double>();
		this.antenna_temp_zero = new ArrayList<Double>();
		this.antenna_temp_one = new ArrayList<Double>();
		try
		{
			fileScanner = new Scanner(this.satDataFile);
			fileScanner.nextLine();
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		this.extractData();
	}
	
	/**
	 * Extracts data from the CSV files and stores the data in their respective instance variables.
	 */
	private void extractData()
	{
		this.fileScanner.useDelimiter(",|\r?\n");
		while(fileScanner.hasNext())
		{
			this.date_and_time.add(fileScanner.next());
			this.solar_panel_voltage_x.add(fileScanner.nextInt());
			this.solar_panel_voltage_y.add(fileScanner.nextInt());
			this.solar_panel_voltage_z.add(fileScanner.nextInt());
			this.total_photo_current.add(fileScanner.nextInt());
			this.battery_voltage.add(fileScanner.nextInt());
			this.total_system_current.add(fileScanner.nextInt());
			this.boost_converter_temp1.add(fileScanner.nextInt());
			this.boost_converter_temp2.add(fileScanner.nextInt());
			this.boost_converter_temp3.add(fileScanner.nextInt());
			this.battery_temp.add(fileScanner.nextInt());
			this.sun_sensor_x_plus.add(fileScanner.nextDouble());
			this.sun_sensor_y_plus.add(fileScanner.nextDouble());
			this.sun_sensor_z_plus.add(fileScanner.nextDouble());
			this.solar_panel_temp_x_plus.add(fileScanner.nextDouble());
			this.solar_panel_temp_x_minus.add(fileScanner.nextDouble());
			this.solar_panel_temp_y_plus.add(fileScanner.nextDouble());
			this.solar_panel_temp_y_minus.add(fileScanner.nextDouble());
			this.three_bus_voltage.add(fileScanner.nextDouble());
			this.three_bus_current.add(fileScanner.nextDouble());
			this.five_bus_voltage.add(fileScanner.nextDouble());
			this.rf_temp.add(fileScanner.nextDouble());
			this.receive_current.add(fileScanner.nextInt());
			this.three_rf_current.add(fileScanner.nextInt());
			this.five_rf_current.add(fileScanner.nextInt());
			this.pa_device_temp.add(fileScanner.nextDouble());
			this.pa_bus_current.add(fileScanner.nextDouble());
			this.antenna_temp_zero.add(fileScanner.nextDouble());
			this.antenna_temp_one.add(fileScanner.nextDouble());
		}
	}

	/**
	 * Retrieves the date and time data
	 * @return the date and time data
	 */
	public ArrayList<String> get_date_and_time()
	{
		return this.date_and_time;
	}
	
	/**
	 * Retrieves the solar panel x voltage data
	 * @return the solar panel x voltage data
	 */
	public ArrayList<Integer> get_solar_panel_voltage_x()
	{
		return this.solar_panel_voltage_x;
	}
	
	/**
	 * Retrieves the solar panel y voltage data
	 * @return the solar panel y voltage data
	 */
	public ArrayList<Integer> get_solar_panel_voltage_y()
	{
		return this.solar_panel_voltage_y;
	}
	
	/**
	 * Retrieves the total photo current
	 * @return the total photo current
	 */
	public ArrayList<Integer> get_total_photo_current()
	{
		return this.total_photo_current;
	}
	
	/**
	 * Retrieves the battery voltage
	 * @return the battery voltage
	 */
	public ArrayList<Integer> get_battery_voltage()
	{
		return this.battery_voltage;
	}
	
	/**
	 * Retrieves the total system current
	 * @return the total system current
	 */
	public ArrayList<Integer> get_total_system_current()
	{
		return this.total_system_current;
	}
	
	/**
	 * Retrieves the boost converter temp 1
	 * @return the boost converter temp 1
	 */
	public ArrayList<Integer> get_boost_converter_temp1()
	{
		return this.boost_converter_temp1;
	}
	
	/**
	 * Retrieves the boost converter temp 2
	 * @return the boost converter temp 2
	 */
	public ArrayList<Integer> get_boost_converter_temp2()
	{
		return this.boost_converter_temp2;
	}
	
	/**
	 * Retrieves the boost converter temp 3
	 * @return the boost converter temp 3
	 */
	public ArrayList<Integer> get_boost_converter_temp3()
	{
		return this.boost_converter_temp3;
	}	
	
	/**
	 * Retrieves the battery temp
	 * @return the battery temp
	 */
	public ArrayList<Integer> get_battery_temp()
	{
		return this.battery_temp;
	}
	
	/**
	 * Retrieves the sun sensor x plus
	 * @return the sun sensor x plus
	 */
	public ArrayList<Double> get_sun_sensor_x_plus()
	{
		return this.sun_sensor_x_plus;
	}
	
	/**
	 * Retrieves the sun sensor y plus
	 * @return the sun sensor y plus
	 */
	public ArrayList<Double> get_sun_sensor_y_plus()
	{
		return this.sun_sensor_y_plus;
	}
	
	/**
	 * Retrieves the sun sensor z plus
	 * @return the sun sensor z plus
	 */
	public ArrayList<Double> get_sun_sensor_z_plus()
	{
		return this.sun_sensor_z_plus;
	}
	
	/**
	 * Retrieves the solar panel temp x plus
	 * @return the solar panel temp x plus
	 */
	public ArrayList<Double> get_solar_panel_temp_x_plus()
	{
		return this.solar_panel_temp_x_plus;
	}
	
	/**
	 * Retrieves the solar panel temp x minus
	 * @return the solar panel temp x minus
	 */
	public ArrayList<Double> get_solar_panel_temp_x_minus()
	{
		return this.solar_panel_temp_x_minus;
	}
	
	/**
	 * Retrieves the solar panel temp y plus
	 * @return the solar panel temp y plus
	 */
	public ArrayList<Double> get_solar_panel_temp_y_plus()
	{
		return this.solar_panel_temp_y_plus;
	}
	
	/**
	 * Retrieves the solar panel temp y minus
	 * @return the solar panel temp y minus
	 */
	public ArrayList<Double> get_solar_panel_temp_y_minus()
	{
		return this.solar_panel_temp_y_minus;
	}
	
	/**
	 * Retrieves the 3.3 bus voltage
	 * @return the 3.3 bus voltage
	 */
	public ArrayList<Double> get_three_bus_voltage()
	{
		return this.three_bus_voltage;
	}
	
	/**
	 * Retrieves the 3.3 bus current
	 * @return the 3.3 bus current
	 */
	public ArrayList<Double> get_three_bus_current()
	{
		return this.three_bus_current;
	}
	
	/**
	 * Retrieves the 5.0 bus voltage
	 * @return the 5.0 bus voltage
	 */
	public ArrayList<Double> get_five_bus_voltage()
	{
		return this.five_bus_voltage;
	}
	
	/**
	 * Retrieves the rf temp
	 * @return the rf temp
	 */
	public ArrayList<Double> get_rf_temp()
	{
		return this.rf_temp;
	}
	
	/**
	 * Retrieves the receive current
	 * @return the receive current
	 */
	public ArrayList<Integer> get_receive_current()
	{
		return this.receive_current;
	}
	
	/**
	 * Retrieves the 3.3 rf current
	 * @return the 3.3 rf current
	 */
	public ArrayList<Integer> get_three_rf_current()
	{
		return this.three_rf_current;
	}
	
	/**
	 * Retrieves the 5.0 rf current
	 * @return the 5.0 rf current
	 */
	public ArrayList<Integer> get_five_rf_current()
	{
		return this.five_rf_current;
	}
	
	/**
	 * Retrieves the pa device temp
	 * @return the pa device temp
	 */
	public ArrayList<Double> get_pa_device_temp()
	{
		return this.pa_device_temp;
	}
	
	/**
	 * Retrieves the pa bus current
	 * @return the pa bus current
	 */
	public ArrayList<Double> get_pa_bus_current()
	{
		return this.pa_bus_current;
	}
	
	/**
	 * Retrieves the antenna temp 0
	 * @return the antenna temp 0
	 */
	public ArrayList<Double> get_antenna_temp_zero()
	{
		return this.antenna_temp_zero;
	}
	
	/**
	 * Retrieves the antenna temp 1
	 * @return the antenna temp 1
	 */
	public ArrayList<Double> get_antenna_temp_one()
	{
		return this.antenna_temp_one;
	}
}

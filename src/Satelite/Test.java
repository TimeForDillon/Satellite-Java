package Satelite;
/**
 * Tests the DataReader class.
 * @author Dillon Welsh
 * @version 0.1
 */
public class Test
{
	public static void main(String[] args)
	{
		DataReader fileReader = new DataReader();
		// Testing file scan
		System.out.println(fileReader.get_date_and_time().size());
		System.out.println(fileReader.get_date_and_time().size());
		System.out.println(fileReader.get_solar_panel_voltage_x().size());
		System.out.println(fileReader.get_solar_panel_voltage_y().size());
		System.out.println(fileReader.get_total_photo_current().size());
		System.out.println(fileReader.get_battery_voltage().size());
		System.out.println(fileReader.get_total_system_current().size());
		System.out.println(fileReader.get_total_system_current().size());
		System.out.println(fileReader.get_boost_converter_temp1().size());
		System.out.println(fileReader.get_boost_converter_temp2().size());
		System.out.println(fileReader.get_boost_converter_temp3().size());
		System.out.println(fileReader.get_battery_temp().size());
		System.out.println(fileReader.get_sun_sensor_x_plus().size());
		System.out.println(fileReader.get_sun_sensor_y_plus().size());
		System.out.println(fileReader.get_sun_sensor_z_plus().size());
		System.out.println(fileReader.get_solar_panel_temp_x_plus().size());
		System.out.println(fileReader.get_solar_panel_temp_x_minus().size());
		System.out.println(fileReader.get_solar_panel_temp_y_plus().size());
		System.out.println(fileReader.get_solar_panel_temp_y_minus().size());
		System.out.println(fileReader.get_three_bus_voltage().size());
		System.out.println(fileReader.get_three_bus_current().size());
		System.out.println(fileReader.get_five_bus_voltage().size());
		System.out.println(fileReader.get_rf_temp().size());
		System.out.println(fileReader.get_receive_current().size());
		System.out.println(fileReader.get_three_rf_current().size());
		System.out.println(fileReader.get_five_rf_current().size());
		System.out.println(fileReader.get_pa_device_temp().size());
		System.out.println(fileReader.get_pa_bus_current().size());
		System.out.println(fileReader.get_antenna_temp_zero().size());
		System.out.println(fileReader.get_antenna_temp_one().size());
	}
}
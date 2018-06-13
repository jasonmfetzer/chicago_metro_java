package chicagoMetroMac;

//currently not working properly**

//index to go in specific direction

//to do, 

//notes, docs
//excel test cases, with file

//create an exit??

//imports, all including unused, gui design went through iterations until final
//gui is main entry point, in main, just gui.gui().
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Caret;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

//gui class
public class gui extends JFrame implements ActionListener {
	// instances of gui, fileName is unUsed.
	private static final long serialVersionUID = 1L;
	private static final String fileName = "";

	// main method
	public static void main(String[] args) throws FileNotFoundException {

		gui.gui();
		//
	}

	// gui as a method call
	public static void gui() throws FileNotFoundException {
		// scanner was for original program , not used as JTextField is user
		// interaction
		Scanner s = new Scanner(System.in);
		// input file, given file is CTAStops.csv, copies creat extra numbers,
		// i.e. (7)
		File file = new File("CTAStops (7).csv");
		// scan file
		Scanner f = new Scanner(file);

		// input verifier class is unused, but deleting the class gave fatal
		// error warning.
		MyInputVerifier iv = new MyInputVerifier();

		// arraylist of stations, and ctaRoutes (new)

		final ArrayList<CTAStation> stops = new ArrayList<CTAStation>();
		final ArrayList<CTARoute> routes = new ArrayList<CTARoute>();

		// final was used in different versions of Eclipse when error was thrown

		// CTARputes, + set Name for each
		final CTARoute red = new CTARoute();
		red.setName("red");

		final CTARoute green = new CTARoute();
		green.setName("green");

		final CTARoute all = new CTARoute();
		all.setName("all");

		final CTARoute blue = new CTARoute();
		blue.setName("blue");

		final CTARoute brown = new CTARoute();
		brown.setName("brown");

		final CTARoute purple = new CTARoute();
		purple.setName("purple");

		final CTARoute pink = new CTARoute();
		pink.setName("pink");

		final CTARoute orange = new CTARoute();
		orange.setName("orange");

		final CTARoute yellow = new CTARoute();
		yellow.setName("yellow");

		final CTARoute transfer = new CTARoute();
		transfer.setName("transfer");

		// added to routes, in order or appearance
		routes.add(red);
		routes.add(green);
		routes.add(blue);
		routes.add(brown);
		routes.add(purple);
		routes.add(pink);
		routes.add(orange);
		routes.add(yellow);

		f.nextLine();

		int i = 0;

		f.nextLine();
		// new Station
		CTAStation chicago = new CTAStation();
		// loop to store
		while (f.hasNextLine()) {

			// store data into array, store each column into CTA station
			// f.nextLine();

			String[] data = f.nextLine().split(",");
			// ctaStation information, setLineColor was removed for the project
			chicago = new CTAStation();

			chicago.setName(data[0]);

			chicago.setLatitude(Double.parseDouble(data[1]));

			chicago.setLongitude(Double.parseDouble(data[2]));

			chicago.setLocation((data[3]));

			chicago.setWheelchair(Boolean.parseBoolean(data[4]));

			// chicago.setLineColorRed(Integer.parseInt(data[5]));
			//
			// chicago.setLineColorGreen(Integer.parseInt(data[6]));
			//
			// chicago.setLineColorBlue(Integer.parseInt(data[7]));
			//
			// chicago.setLineColorBrown(Integer.parseInt(data[8]));
			//
			// chicago.setLineColorPurple(Integer.parseInt(data[9]));
			//
			// chicago.setLineColorPink(Integer.parseInt(data[10]));
			//
			// chicago.setLineColorOrange(Integer.parseInt(data[11]));
			//
			// chicago.setLineColorYellow(Integer.parseInt(data[12]));

			// line positions for 8 different routes, add from data, csv input.
			int[] linePositions = new int[8];
			for (int y = 0; y < linePositions.length; y++) {
				linePositions[y] = Integer.parseInt(data[y + 5]);

			}
			// from setRoutes method
			chicago.setRoutes(routes, linePositions);

			// chicago.setTransfer(Integer.parseInt(data[5]));

			// arraylist is used for size in gui
			stops.add(chicago);

			// previous versions of the app stored data this way.
			// store in ctaRoute
			// if(chicago.getLineColorGreen()>=0) {
			// green.addStation(chicago);
			// }
			// if(chicago.getLineColorRed()>=0) {
			// red.addStation(chicago);
			// //transfer.addStation(chicago);
			//
			// }
			// if(chicago.getLineColorBlue()>=0) {
			// blue.addStation(chicago);
			//
			// }
			// if(chicago.getLineColorBrown()>=0) {
			// brown.addStation(chicago);
			//
			// }
			// if(chicago.getLineColorPurple()>=0) {
			// purple.addStation(chicago);
			//
			// }
			// if(chicago.getLineColorPink()>=0) {
			// pink.addStation(chicago);
			//
			// }
			// if(chicago.getLineColorOrange()>=0) {
			// orange.addStation(chicago);
			//
			// }
			// if(chicago.getLineColorYellow()>=0) {
			// yellow.addStation(chicago);
			//
			// }
			// if(chicago.getisTransfer()>0) {
			// transfer.addStation(chicago);
			// }

			// list of all stations
			all.addStation(chicago);
			// add all routes
			for (CTARoute route : chicago.getRoutes()) {
				route.addStation(chicago);
			}

			// for(int z = 0; z <routes.size(); z++) {
			// if(Integer.parseInt(data[z+5])>=0){
			// routes.get(z).addStation(chicago);
			// }
			// }
			// increment each
			i++;

		}

		// System.out.println(all.getStops().toString());
		// to store image
		BufferedImage img = null;// hold variable
		// try catch to read file, two separate files are given, used a Cubs.jpg
		// and ctaSystemPic.jpg, both should be included in zip
		try {
			img = ImageIO.read(new File("ctaSystemPic.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// main Jframe with name
		JFrame frame = new JFrame("Welcome To Chicago");
		// exit requirement
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// grid layout was used to give even rows and column appearance
		JPanel panel = new JPanel(new GridLayout(5, 10, 5, 5));

		// used as the ImageIcon for pic placement
		JPanel picturePanel = new JPanel(new GridLayout(1, 1, 1, 1));
		new ImageIcon("ctaSystemPic.JPG");
		// scale image to fit JFrame and panel
		Image newOne = img.getScaledInstance(300, 300, 0);
		ImageIcon image2 = new ImageIcon(newOne);
		// JLabel picToDisplay = new JLabel();
		// placement in frame
		JLabel picToDisplay = new JLabel("", image2, JLabel.RIGHT);

		// add the pic to the panel
		picturePanel.add(picToDisplay);

		// picturePanel.setLayout(layout);
		// set sizes and boolean true to show
		panel.setSize(1000, 300);
		picturePanel.setSize(550, 300);
		picturePanel.setVisible(true);

		// set frame size
		frame.setSize(1300, 325);
		// add panel and picture panel to the frame
		frame.add(panel);
		frame.add(picturePanel);

		// set background color
		panel.setBackground(Color.darkGray);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// buttons

		// each operation is separated with their respective fields, buttons,
		// and operations
		// get a route, text fields to take in start and end stations
		final JTextField startStation = new JTextField();
		final JTextField endStation = new JTextField();
		// action button to show directions, unused as "get Route" was added
		// later
		new JButton("Show Directions");
		// save to file button
		JButton toCSV = new JButton("Save to File");
		// add the action listener
		toCSV.addActionListener(new ActionListener() {
			@SuppressWarnings("resource")
			// action performed, do something
			public void actionPerformed(ActionEvent e) {
				// file is stored in working directory of environment
				File fileName = new File("cta.txt");
				// new filewriter
				FileWriter fw;
				try {
					// bufferedwriter to write data
					fw = new FileWriter(fileName);
					BufferedWriter bw = new BufferedWriter(fw);
					// new route for path between end index and start index
					CTARoute path = new CTARoute();
					// path.toString();
					// start station declaration
					CTAStation starter = all.lookupStation(startStation
							.getText());
					// need checks, i.e. station does not exist, etc.
					if (starter == null) {
						JOptionPane.showMessageDialog(null,
								"We could not find the starting station");
						return;
					}
					CTAStation ender = all.lookupStation(endStation.getText());
					if (ender == null) {
						JOptionPane.showMessageDialog(null,
								"We could not find your destination");
						return;
					}
					// call get path method on starting and ending station,
					// returns array list
					path.getPath(starter, ender);
					for (@SuppressWarnings("unused")
					CTARoute route : routes) {
						path.setStops(path.getStops());// all stops, need
														// indexing of stops
					}
					// write directions to file as string
					bw.write(path.getPath(starter, ender).toString());
					
					// close writers
					bw.close();
					fw.close();
					// show message confirm dialog, you saved the file (saved as
					// to.String() format
					JList writesTo = new JList(path.getPath(starter, ender).toArray());
					JScrollPane write = new JScrollPane(writesTo);
					
					JOptionPane.showMessageDialog(
							null,
							/**"Saved to cta.txt in wd" + "\n"**/
									 write);
					//file will display as one long string in text editor from eclipse environment, but break down lines when accessed from folder
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// console test, written to file
				// System.out.println("Done");

			}
		});
		// delete frame was attempted to use a JTable, but ultimately proved too
		// time consuming

		JFrame deleteFrame = new JFrame();

		// delete label, text field for deleting, and button to delete
		JLabel deleteMe = new JLabel("DELETE STATION");
		deleteMe.setForeground(Color.WHITE);
		final JFormattedTextField toBeDeleted = new JFormattedTextField();

		JButton delete = new JButton("Delete");
		// add the action listener to the button for deletion
		delete.addActionListener(new ActionListener() {
			// actionPerformed method
			public void actionPerformed(ActionEvent e) {
				// station to be deleted from the list in string format
				String toRemove = toBeDeleted.getText();
				// station to delete
				CTAStation deleteable = all.lookupStation(toRemove);
				// form new arraylist
				ArrayList<String> deleteSelection = new ArrayList<>();

				// for loop, check input name to match with current list, to
				// show multiple outputs (Oak Park), etc.
				for (int i = 0; i < stops.size(); i++) {
					if (toRemove.equals(stops.get(i).getName())) {
						deleteSelection.add(all.getStops().get(i).toString());

					}

					//
				}
				// add strings to array
				@SuppressWarnings("unchecked")
				JList<?> del = new JList(deleteSelection.toArray());
				JTextField paneTrial = new JTextField("Enter specific latitude");
				// show dialog for multiple values, or individual
				JOptionPane.showMessageDialog(null, del);
				// if value not found, display not found
				if (deleteable == null) {
					JOptionPane.showMessageDialog(null, "not found");

					return;
				} else {

					// else remove from all list, and remove from specific route
					all.removeStation(deleteable);
					for (int i = 0; i < routes.size(); i++) {

						routes.get(i).removeStation(deleteable);
						// all.removeStation(station);
					}
					// confirmation dialog
					JOptionPane.showMessageDialog(null, "You deleted "
							+ deleteable.toString());
				}
			}
		});

		// get a route portion, just " Get Route " specifically to a pane
		JButton showRoute = new JButton("Get Route");
		// add action listener to the button
		showRoute.addActionListener(new ActionListener() {
			// method to do something
			public void actionPerformed(ActionEvent e) {
				// new PATH, i.e. start to end
				CTARoute path = new CTARoute();
				// look up start station, if it doesn't exist, throw error
				CTAStation starter = all.lookupStation(startStation.getText());
				if (starter == null) {
					JOptionPane.showMessageDialog(null,
							"We could not find the starting station");
					return;
				}// look up end station
				CTAStation ender = all.lookupStation(endStation.getText());
				if (ender == null) {
					JOptionPane.showMessageDialog(null,
							"We could not find your destination");
					return;
				}// call path method, currently only for same route
				path.getPath(starter, ender);
				ArrayList<?> pather = new ArrayList<>();
				for (int x = 0; x < stops.size(); x++) {
					// empty loop, moved to the method itself in CTARoute
				}
				// make a list for directions, display the list
				JList direction = new JList(path.getPath(starter, ender)
						.toArray());
				JScrollPane directional = new JScrollPane(direction);
				// direction.add(path.getPath(starter, ender).toArray());
				JOptionPane.showMessageDialog(null, directional);
			}
		});
		// check boxes for disability and location
		final JCheckBox disabledBox = new JCheckBox("WheelChair Access");
		final JCheckBox elevated = new JCheckBox("Elevated");

		// take in staion
		final JTextField stationList = new JTextField("Type Here:");
		// unused TextField
		new JTextField(5);

		// search for all stations button
		JButton searchButton = new JButton("Search");

		// add the action listener
		searchButton.addActionListener(new ActionListener() {
			// method for action
			public void actionPerformed(ActionEvent e) {
				// take String as arg
				String input = stationList.getText();
				// if(input.equals(all.getName())) {
				// System.out.println(input);
				// }
				// unused RadioButton, was going to be used to select from
				// multiple items
				JRadioButton bu = new JRadioButton();

				// variables for lookup station, add all to an array list of
				// strings
				ArrayList<String> trialStation = new ArrayList<>();
				CTAStation lookup = all.lookupStation(input);

				for (int i = 0; i < stops.size(); i++) {
					if (input.equals(stops.get(i).getName())) {
						// CTARoute[] trial = new CTARoute[stops.size()];
						// trialStation.add((CTARoute)
						// stops.get(i).getRoutes());
						// trialStation.add(stops.get(i).getRoutes().toString());
						trialStation.add(all.getStops().get(i).toString());

						// trials for other options
						// trialStation.addAll(all.getStops().get(i).getRoutes().toArray());
						// System.out.println(stops.get(i).getRoutes().toString());

						// System.out.println(all.getStops().get(i).toStringX(true));

					}
				}

				String texted;
				if (lookup == null) {
					JOptionPane.showMessageDialog(null, "The station " + input
							+ " couldn't be found. Try Again.");
				} else {
					texted = lookup.toString();

					JList<?> listed = new JList(trialStation.toArray());
					JOptionPane.showMessageDialog(null, listed);

				}

				// initial pass with toString

				// JOptionPane.showMessageDialog(null, texted);

			}
		});

		// GeoLocation get closest options
		// labels and buttons, arraylist to store data
		final ArrayList<String> closest = new ArrayList();
		final JTextField empty24 = new JTextField();
		JLabel nearestLat = new JLabel("Enter Lat:");
		nearestLat.setForeground(Color.LIGHT_GRAY);
		JLabel nearestLong = new JLabel("Enter Long:");
		nearestLong.setForeground(Color.LIGHT_GRAY);
		final JTextField latitudeEntry = new JTextField();
		final JTextField longitudeEntry = new JTextField();
		JButton nearestButton = new JButton("Find Closest");

		// add the action listener
		nearestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GeoLocation near = new GeoLocation();

				try {
					double lat = Double.parseDouble(latitudeEntry.getText());

					double longi = Double.parseDouble(longitudeEntry.getText());

					near.setLatitude(lat);
					near.setLongitude(longi);
				} catch (NumberFormatException geo) {
					JOptionPane.showMessageDialog(null,
							"Something's not right, Number Expected");
				}
				Double maxDistance;
				try {
					maxDistance = Double.parseDouble(empty24.getText());
					for (int d = 0; d < all.getStops().size(); d++) {

						// if(near.calcDistance(all.getStops().get(d).getLatitude(),
						// all.getStops().get(d).getLongitude())<maxDistance) {
						// closest.add(all.getStops().get(d).toString());
						// }
						
						if (near.calcDistance(all.getStops().get(d)) < maxDistance) {
							closest.add(all.getStops().get(d).toString());
							//System.out.println(all.getStops().size());
						}
					}// catch error for double only
				} catch (NumberFormatException dist) {
					JOptionPane.showMessageDialog(null,
							"Did you enter only numbers?");
				}
				// make a list, add the array from loop, display to screen in
				// option pane
				@SuppressWarnings("unchecked")
				JList<?> close = new JList(closest.toArray());

				JOptionPane.showMessageDialog(null, close);

			}
		});

		// unused
		// new JTextField(5);

		// CREATE A STATION
		// labels, text fields, action button "modify"
		JLabel createStation = new JLabel("ADD STATION");
		createStation.setForeground(Color.WHITE);

		JLabel addStationLat = new JLabel("Enter Lat.");
		addStationLat.setForeground(Color.LIGHT_GRAY);

		JLabel addStationLong = new JLabel("Enter Long.");
		addStationLong.setForeground(Color.LIGHT_GRAY);

		// text field entries
		final JTextField stationNameToAdd = new JTextField("Name...");
		final JTextField stationRouteToAdd = new JTextField("Route...");
		final JTextField numbers = new JTextField("Stop Number...");
		final JTextField latitudeEntryAdd = new JTextField();
		final JTextField longitudeEntryAdd = new JTextField();

		// the action button to add
		JButton modifyButton = new JButton("Add");

		// add the action listener
		modifyButton.addActionListener(new ActionListener() {
			// create method to create station
			public void actionPerformed(ActionEvent e) {
				CTAStation newStation = new CTAStation();
				//Double point;
				
				// try catch block, for double number format exception
				try {
					Double addLat = Double.parseDouble(latitudeEntryAdd
							.getText());
					Double point = Double.parseDouble(numbers.getText());
					Double addLong = Double.parseDouble(longitudeEntryAdd
							.getText());
					newStation.setLatitude(addLat);
					newStation.setLongitude(addLong);
				} catch (NumberFormatException latLong) {
					JOptionPane.showMessageDialog(null,
							"A numerical value is expected for lat/lng fields");
				}
				// Boolean isWheel; set values
				if (disabledBox.isSelected()) {
					newStation.setWheelchair(true);
				} else {
					newStation.setWheelchair(false);
				}
				// Boolean elevate; set values
				if (elevated.isSelected()) {
					newStation.setOpened(true);
				} else {
					newStation.setOpened(false);
				}

				// try catch block for user input validation
				try {
					String nameFromUser = stationNameToAdd.getText();
					newStation.setName(nameFromUser);
					String routeColor = stationRouteToAdd.getText();

					if (routeColor.equalsIgnoreCase("green")) {
						green.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("red")) {
						red.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("blue")) {
						blue.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("pink")) {
						pink.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("purple")) {
						purple.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("brown")) {
						brown.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("yellow")) {
						yellow.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("orange")) {
						orange.addStation(newStation);
					} else if (routeColor.equalsIgnoreCase("pink")) {
						pink.addStation(newStation);

					} // catch the block for ensuring all inputs are filled
				} catch (IllegalFormatException legits) {
					JOptionPane.showMessageDialog(null,
							"Did you enter all the fields correctly?");
				}
				// stops.add(newStation);

				// add to route, and all list
				all.addStation(newStation);
				//all.insertStation(newStation);
				JOptionPane.showMessageDialog(null, "Hey you added "
						+ newStation.toString());
			}
		});

		// Labels for route
		JLabel routeLabel = new JLabel("GET ROUTE");
		routeLabel.setForeground(Color.WHITE);

		// unused items
		JLabel addDeleteRow = new JLabel("Add or Delete a Station");
		addDeleteRow.setForeground(Color.WHITE);

		JLabel stationInfo = new JLabel("STATION INFO");
		stationInfo.setForeground(Color.WHITE);

		JLabel startingStation = new JLabel("Start Station");
		startingStation.setForeground(Color.LIGHT_GRAY);
		JLabel endingStation = new JLabel("End Station");
		endingStation.setForeground(Color.LIGHT_GRAY);

		// show all values
		JButton getAll = new JButton("Show All");

		// add the action listener
		getAll.addActionListener(new ActionListener() {

			// method to list all stops, if duplicate, will display all
			public void actionPerformed(ActionEvent e) {
				JList list = new JList(all.getStops().toArray());
				list.setSize(50, 50);
				JScrollPane pane = new JScrollPane(list);
				JOptionPane.showMessageDialog(null, pane);
			}
		});

		// label for indiv. station search
		JLabel stationNames = new JLabel("Indiv. Station:");
		stationNames.setForeground(Color.LIGHT_GRAY);

		// label for geo
		JLabel findNear = new JLabel("FIND CLOSEST");
		findNear.setForeground(Color.WHITE);

		/**
		 * layout is grid layout, therefore eclipse will autoSize rows and
		 * columns based on an even division, I set empty values to fill //the
		 * actual outputs I needed , and then set the empty labels to fill in
		 * gaps.
		 **/
		JLabel empty = new JLabel();
		JLabel empty2 = new JLabel();
		JLabel empty3 = new JLabel();
		JLabel empty4 = new JLabel();
		JLabel empty5 = new JLabel();
		JLabel empty6 = new JLabel();
		JLabel empty7 = new JLabel();
		JLabel empty8 = new JLabel();
		JLabel empty9 = new JLabel();
		JLabel empty10 = new JLabel();
		JLabel empty11 = new JLabel();

		JLabel empty13 = new JLabel();
		JLabel empty14 = new JLabel();
		JLabel empty15 = new JLabel();
		JLabel empty16 = new JLabel();
		JLabel empty17 = new JLabel();
		JLabel empty18 = new JLabel();
		JLabel empty19 = new JLabel();
		JLabel empty20 = new JLabel();

		// duplicates
		JLabel empty21 = new JLabel("Indiv. Station:");
		empty21.setForeground(Color.LIGHT_GRAY);
		JLabel empty22 = new JLabel();
		JLabel empty23 = new JLabel("Max Distance:");
		empty23.setForeground(Color.LIGHT_GRAY);

		JLabel allLabel = new JLabel("All STATIONS");
		allLabel.setForeground(Color.LIGHT_GRAY);

		// stored in case features were added
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();
		new JLabel();

		// "Get Station Info Row
		panel.add(stationInfo);
		panel.add(empty);
		panel.add(empty2);
		panel.add(empty3);
		panel.add(empty4);
		panel.add(empty11);
		panel.add(allLabel);// see all
		panel.add(getAll);// all button action listener
		panel.add(stationNames);
		panel.add(stationList);
		panel.add(searchButton);

		// Get Route Row
		panel.add(routeLabel);
		panel.add(empty5);
		panel.add(empty16);
		panel.add(empty17);
		panel.add(empty18);
		panel.add(startingStation);
		panel.add(startStation);
		panel.add(endingStation);
		panel.add(endStation);
		panel.add(showRoute);
		panel.add(toCSV);

		// Modify station Row
		panel.add(createStation);
		panel.add(stationNameToAdd);
		panel.add(stationRouteToAdd);
		panel.add(numbers);
		panel.add(addStationLat);
		panel.add(latitudeEntryAdd);
		panel.add(addStationLong);
		panel.add(longitudeEntryAdd);
		panel.add(disabledBox);
		panel.add(elevated);
		panel.add(modifyButton);

		// Delet station Row
		panel.add(deleteMe);
		panel.add(empty6);
		panel.add(empty7);
		panel.add(empty8);
		panel.add(empty9);
		panel.add(empty10);
		panel.add(empty19);
		panel.add(empty20);
		panel.add(empty21);
		panel.add(toBeDeleted);
		panel.add(delete);

		// GeoLocation Row
		panel.add(findNear);
		panel.add(empty13);
		panel.add(empty14);
		panel.add(empty22);
		panel.add(empty23);
		panel.add(empty24);
		panel.add(nearestLat);
		panel.add(latitudeEntry);
		panel.add(nearestLong);
		panel.add(longitudeEntry, null);
		panel.add(nearestButton);

		// panel.add(empty11);
		// panel.add(empty12);

		// set visible
		frame.setVisible(true);
		panel.setVisible(true);

	}

	// method for frustration
	public void actionPerformed(ActionEvent ev) {
		JOptionPane.showMessageDialog(null, "fuck me");

	}

	// duplicate method for writing to CSV, moved to actionlistener
	public void writeToFile() {
		BufferedWriter bw = null;
		FileWriter fw = null;
		CTARoute writeable = new CTARoute();
		CTAStation starting = new CTAStation();
		CTAStation ending = new CTAStation();

		// try {
		// writeable.getPath(, end);
		// }
	}

}
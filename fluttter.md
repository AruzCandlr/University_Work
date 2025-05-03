📦 MaterialApp
Usage:

dart
Copy
Edit
MaterialApp(
  home: HomePage(),
  debugShowCheckedModeBanner: false,
)
Purpose: Entry point of your app UI with routing, themes, and navigation.

🧱 Scaffold
Usage:

dart
Copy
Edit
Scaffold(
  appBar: AppBar(title: Text("Home")),
  body: Center(child: Text("Hello")),
  backgroundColor: Colors.white,
)
Purpose: Provides a standard app page structure with app bar, body, etc.

🧭 AppBar
Usage:

dart
Copy
Edit
AppBar(
  title: Text("Menu"),
  centerTitle: true,
  backgroundColor: Colors.white,
  leading: Icon(Icons.home),
  actions: [Icon(Icons.search)],
)
Purpose: Top navigation and action toolbar.

🔍 TextField
Usage:

dart
Copy
Edit
TextField(
  decoration: InputDecoration(
    hintText: 'Search...',
    prefixIcon: Icon(Icons.search),
    border: OutlineInputBorder(),
  ),
  onChanged: (value) => print(value),
)
Purpose: Input field for search, forms, etc.

🎨 InputDecoration
Usage (used inside TextField):

dart
Copy
Edit
InputDecoration(
  hintText: "Search food",
  prefixIcon: Icon(Icons.search),
  suffixIcon: Icon(Icons.filter_list),
  filled: true,
  fillColor: Colors.grey[200],
  border: OutlineInputBorder(borderRadius: BorderRadius.circular(10)),
)
Purpose: Adds visual decoration and interactivity to input fields.

📜 ListView.separated
Usage:

dart
Copy
Edit
ListView.separated(
  itemCount: 5,
  itemBuilder: (context, index) => ListTile(title: Text("Item $index")),
  separatorBuilder: (context, index) => Divider(),
)
Purpose: Scrollable list with separators between items.

📦 Container
Usage:

dart
Copy
Edit
Container(
  width: 100,
  height: 100,
  padding: EdgeInsets.all(10),
  margin: EdgeInsets.symmetric(horizontal: 5),
  decoration: BoxDecoration(color: Colors.blue, borderRadius: BorderRadius.circular(10)),
  child: Text("Box"),
)
Purpose: Basic box model for layout, styling, and alignment.

📐 Column / Row
Usage:

dart
Copy
Edit
Column(
  mainAxisAlignment: MainAxisAlignment.center,
  crossAxisAlignment: CrossAxisAlignment.start,
  children: [
    Text("Line 1"),
    Text("Line 2"),
  ],
)

Row(
  mainAxisAlignment: MainAxisAlignment.spaceBetween,
  children: [
    Icon(Icons.menu),
    Text("Title"),
    Icon(Icons.settings),
  ],
)
Purpose: Vertical (Column) or horizontal (Row) layout of widgets.

⚪ CircleAvatar
Usage:

dart
Copy
Edit
CircleAvatar(
  backgroundColor: Colors.white,
  child: Icon(Icons.person),
)
Purpose: Rounded icon or image container, often used for profile pictures.

🖼️ SvgPicture.asset (from flutter_svg package)
Usage:

dart
Copy
Edit
SvgPicture.asset(
  'assets/icons/pancake.svg',
  width: 40,
  height: 40,
  fit: BoxFit.contain,
)
Purpose: Renders SVG images (vector icons).

❤️ Icon
Usage:

dart
Copy
Edit
Icon(
  Icons.favorite,
  color: Colors.red,
  size: 30,
)
Purpose: Display icons from the Material icon set.

⬛ Expanded
Usage:

dart
Copy
Edit
Row(
  children: [
    Expanded(
      child: Text("This text expands to fill available space."),
    ),
    Icon(Icons.check),
  ],
)
Purpose: Makes a widget fill the available space in a Row or Column.

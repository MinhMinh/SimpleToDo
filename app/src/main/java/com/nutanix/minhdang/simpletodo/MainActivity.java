package com.nutanix.minhdang.simpletodo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends Activity {

    private final String TAG = "MainActivity";

    TodoItemDatabase db;
    List<TodoItem> items;
    //TodoAdapter itemsAdapter;
    //ListView lvItems;
    //private final int REQUEST_CODE = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new TodoItemDatabase(this);
        db.addTodoItem(new TodoItem("One", 1));
        db.addTodoItem(new TodoItem("Two", 2));

        items = db.getAllTodoItems();

        for (TodoItem ti : items) {
            String log = "Id: " + ti.getId() + " , Body: " + ti.getBody() +
                    " , Priority: " + ti.getPriority();

            Log.d("Name: ", log);
        }

        /*
        lvItems = (ListView) findViewById(R.id.lvItems);
        readItems();
        itemsAdapter = new TodoAdapter(this, items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
        */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            String item_name = data.getExtras().getString("item_name");
            int pos = data.getExtras().getInt("position", 0);
            items.remove(pos);
            items.add(pos, new TodoItem(item_name, 1));
            itemsAdapter.notifyDataSetChanged();
            writeItems();
        }
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(new TodoItem(itemText, 1));
        etNewItem.setText("");
        db.addTodoItem(new TodoItem(itemText, 1));
    }

    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView,
                                                   View view, int pos, long id) {
                        db.deleteTodoItem(items.get(pos));
                        items.remove(pos);
                        itemsAdapter.notifyDataSetChanged();
                        return true;
                    }
                }
        );

        lvItems.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView,
                                            View view, int pos, long id) {
                        Intent i = new Intent(MainActivity.this, EditItemActivity.class);
                        i.putExtra("item_name", items.get(pos).getBody());
                        i.putExtra("position", pos);
                        startActivityForResult(i, REQUEST_CODE);
                    }
                }
        );
    }

    private void readItems() {
        Log.d(TAG, "readItems");
        items = new ArrayList<TodoItem>(db.getAllTodoItems());
    }

    private void writeItems() {
        File filesDir = getFilesDir();
        File todoFile = new File(filesDir, "todo.txt");
        try {
            FileUtils.writeLines(todoFile, items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */
}
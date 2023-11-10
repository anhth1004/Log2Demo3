    package com.example.log2demo3;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    import android.widget.ImageView;

    public class MainActivity extends AppCompatActivity {

        // Mảng chứa ID của các tài nguyên hình ảnh trong thư mục res/drawable
        int[] imageResourceIds = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

        // Vị trí hiện tại của hình ảnh đang được hiển thị
        int currentPosition = 0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            // Tìm ImageView và nút Previous và Next trong layout
            ImageView imageView = findViewById(R.id.imageView);
            Button btnPrev = findViewById(R.id.btnPrev);
            Button btnNext = findViewById(R.id.btnNext);

            // Thiết lập hình ảnh ban đầu cho ImageView
            imageView.setImageResource(imageResourceIds[currentPosition]);

            // Xử lý sự kiện khi nút Previous được nhấn
            btnPrev.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Di chuyển đến hình ảnh trước đó (nếu có)
                    currentPosition--;
                    if (currentPosition < 0) {
                        // Nếu đang ở hình ảnh đầu tiên, quay lại hình ảnh cuối cùng
                        currentPosition = imageResourceIds.length - 1;
                    }
                    // Hiển thị hình ảnh mới
                    imageView.setImageResource(imageResourceIds[currentPosition]);
                }
            });

            // Xử lý sự kiện khi nút Next được nhấn
            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Di chuyển đến hình ảnh tiếp theo (nếu có)
                    currentPosition++;
                    if (currentPosition >= imageResourceIds.length) {
                        // Nếu đang ở hình ảnh cuối cùng, quay lại hình ảnh đầu tiên
                        currentPosition = 0;
                    }
                    // Hiển thị hình ảnh mới
                    imageView.setImageResource(imageResourceIds[currentPosition]);
                }
            });
        }
    }

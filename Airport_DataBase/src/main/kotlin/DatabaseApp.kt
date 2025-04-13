import javax.swing.*
import javax.swing.table.DefaultTableModel
import java.awt.*
import java.awt.event.ActionEvent

class DatabaseApp {
    // Основные компоненты UI
    private val frame = JFrame("Database Client").apply {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        size = Dimension(1000, 600)
        minimumSize = Dimension(800, 400)
    }

    private val tableModel = DefaultTableModel()
    private val table = JTable(tableModel)
    private val statusBar = JLabel(" Готово к работе").apply {
        border = BorderFactory.createEtchedBorder()
    }

    fun show() {
        setupUI()
        frame.isVisible = true
    }

    private fun setupUI() {
        // Главный контейнер
        val mainPanel = JPanel(BorderLayout())

        // Панель инструментов
        val toolPanel = JPanel(FlowLayout(FlowLayout.LEFT)).apply {
            add(JButton("Подключиться").apply {
                addActionListener { showConnectionDialog() }
            })
            add(JButton("Выполнить запрос").apply {
                addActionListener { showQueryDialog() }
            })
            add(JButton("Экспорт").apply {
                addActionListener { exportData() }
            })
        }

        // Таблица с данными
        val scrollPane = JScrollPane(table).apply {
            preferredSize = Dimension(950, 400)
        }

        // Добавляем компоненты
        mainPanel.add(toolPanel, BorderLayout.NORTH)
        mainPanel.add(scrollPane, BorderLayout.CENTER)
        mainPanel.add(statusBar, BorderLayout.SOUTH)

        // Заполняем таблицу тестовыми данными (для демонстрации)
        showSampleData()

        frame.contentPane = mainPanel
        frame.centerOnScreen()
    }

    private fun showSampleData() {
        tableModel.apply {
            setColumnIdentifiers(arrayOf("ID", "Наименование", "Дата", "Статус"))
            addRow(arrayOf("1", "Тестовая запись 1", "2023-01-01", "Активен"))
            addRow(arrayOf("2", "Тестовая запись 2", "2023-01-02", "Неактивен"))
        }
    }

    private fun showConnectionDialog() {
        JOptionPane.showMessageDialog(
            frame,
            "Функция подключения к БД будет реализована позже",
            "Подключение к базе",
            JOptionPane.INFORMATION_MESSAGE
        )
    }

    private fun showQueryDialog() {
        JOptionPane.showMessageDialog(
            frame,
            "Здесь будет окно для ввода SQL-запросов",
            "Выполнение запроса",
            JOptionPane.INFORMATION_MESSAGE
        )
    }

    private fun exportData() {
        val option = JOptionPane.showOptionDialog(
            frame,
            "Экспортировать данные в:",
            "Экспорт данных",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            arrayOf("CSV", "Excel", "Отмена"),
            "CSV"
        )

        when (option) {
            0 -> statusBar.text = " Экспорт в CSV..."
            1 -> statusBar.text = " Экспорт в Excel..."
        }
    }

    private fun JFrame.centerOnScreen() {
        setLocationRelativeTo(null)
    }
}
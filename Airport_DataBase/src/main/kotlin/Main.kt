import javax.swing.*
fun main(args: Array<String>) {
    println("Start application using tornadofx and pl sql")

    SwingUtilities.invokeLater {
        DatabaseApp().show()
    }
}
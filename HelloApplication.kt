package com.example.readimage3
// Perfit project
// May 23, 2022
import javafx.application.Application
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.text.Font
import javafx.scene.text.FontPosture
import javafx.scene.text.FontWeight
import javafx.stage.Stage
import java.util.*
import java.util.function.Consumer

//import java.awt.TextField

class HelloApplication : Application() {

    var textFieldLeft: TextField? = null
    var textFieldRight: TextField? = null

    var textFieldEmail: TextField? = null
    var send: Button? = null
    var grid: GridPane? = null


    var firstName: Label? = null
    var lastName: Label? = null
    var email: Label? = null

    var listOfMeasuremts: LinkedList<Double>? = null
    var rowNumber = 1
    var backgroundFill: BackgroundFill? = null
    var background: Background? = null
    override fun start(stage: Stage) {

        try {
            listOfMeasuremts = LinkedList()

//            val iv = ImageView()
//            iv.image = anImage
//            // to choose to preserve image's width and height
//            iv.isPreserveRatio = false
//            iv.rotate = 90.0
//            iv.rotate = 360.0
//            iv.fitWidth = 100.0
//            iv.fitHeight = 100.0
//            root.alignment = Pos.BOTTOM_CENTER

//            root.getChildren().add(iv)
            stage.scene = scene
            stage.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        grid = GridPane()
        backgroundFill = BackgroundFill(Color.ROSYBROWN, CornerRadii.EMPTY, Insets.EMPTY)
        background = Background(backgroundFill)
        grid!!.setBackground(background)

        textFieldLeft = TextField("")
        textFieldRight = TextField("")

        textFieldEmail = TextField("")
        send = Button("Sign up")

        firstName = Label("First Name*:")
        lastName = Label("Last Name*:")
        email = Label("Email*:")

        textFieldLeft!!.font = Font.font(textFieldLeft!!.text, FontPosture.ITALIC, 18.0)
        textFieldRight!!.font = Font.font(textFieldRight!!.text, FontPosture.ITALIC, 18.0)

        textFieldEmail!!.font = Font.font(textFieldEmail!!.text, FontPosture.ITALIC, 18.0)
        send!!.font = Font.font(send!!.text, FontPosture.ITALIC, 18.0)

        firstName!!.font = Font.font(firstName!!.text, FontPosture.ITALIC, 18.0)
        lastName!!.font = Font.font(lastName!!.text, FontPosture.ITALIC, 18.0)
        email!!.font = Font.font(email!!.text, FontPosture.ITALIC, 18.0)


        val columnL = ColumnConstraints(50.0, 100.0, 150.0)
        val columnML = ColumnConstraints(50.0, 100.0, 150.0)
        val columnMR = ColumnConstraints(50.0, 100.0, 150.0)
        val columnR = ColumnConstraints(50.0, 100.0, 150.0)
        val columnRR = ColumnConstraints(50.0, 100.0, 150.0)
        val columnRL = ColumnConstraints(50.0, 100.0, 150.0)

        val row1 = RowConstraints(40.0, 60.0, 80.0)
        val row2 = RowConstraints(40.0, 60.0, 80.0)
        val row3 = RowConstraints(40.0, 60.0, 80.0)
        val row4 = RowConstraints(40.0, 60.0, 80.0)
        val row5 = RowConstraints(40.0, 60.0, 80.0)
        val row6 = RowConstraints(40.0, 60.0, 80.0)

        grid!!.getColumnConstraints().addAll(columnL, columnML, columnMR, columnR, columnRR, columnRL)
        grid!!.getRowConstraints().addAll(row1, row2, row3, row4, row5, row6)

        GridPane.setColumnSpan(textFieldLeft, 2)
        GridPane.setColumnSpan(textFieldRight, 2)
        GridPane.setColumnSpan(textFieldEmail, 2)
        GridPane.setColumnSpan(send, 2)

        grid!!.add(firstName, 1, 4)
        grid!!.add(textFieldLeft, 2, 4)
        grid!!.add(lastName, 5, 4)
        grid!!.add(textFieldRight, 6, 4)

        grid!!.add(email, 1, 5)
        grid!!.add(textFieldEmail, 2, 5)

        grid!!.add(send, 2, 6)

        grid!!.hgap = 20.0
        grid!!.vgap = 20.0

        send!!.onAction = EventHandler { actionEvent: ActionEvent? ->
            this.getNewView(
                actionEvent
            )
        }
        root.children.addAll(grid)
    }

    var anImage = Image("file:Rattlers_mens_front_website.png")
//    var imageInput = Image("Rattlers_ladies_front.jpeg")
    var root = StackPane()
    var scene = Scene(root, 1200.0, 800.0)

    //        stage.setTitle("Hello!");
    //        stage.setScene(scene);
    //        stage.show();
    protected fun getNewView(actionEvent: ActionEvent?) {
        val grid2 = GridPane()
        val backgroundFill2 = BackgroundFill(Color.MISTYROSE, CornerRadii.EMPTY, Insets.EMPTY)
        val background2 = Background(backgroundFill2)
        grid2.background = background2

        val columnL2 = ColumnConstraints(100.0, 150.0, 200.0)
        val columnML2 = ColumnConstraints(100.0, 150.0, 200.0)
        val columnMR2 = ColumnConstraints(100.0, 150.0, 200.0)
        val columnR2 = ColumnConstraints(100.0, 150.0, 200.0)
        val columnR3 = ColumnConstraints(100.0, 150.0, 200.0)

        val rowTop2 = RowConstraints(50.0, 75.0, 100.0)

        grid2.getColumnConstraints().addAll(columnL2, columnML2, columnMR2, columnR2,columnR3)
        grid2.getRowConstraints().addAll(rowTop2)


        val typeOfMeasuremt = Label("Type of Measurement")
        val input = Label("Input Measurement\n" +
            "(in centimeters)");
        GridPane.setColumnSpan(input,2);

        val A = Label("Shoulder Width")
        A.alignment = Pos.CENTER
        val inputA = TextField("cm")

        val B = Label("Chest/Bust")
        val inputB = TextField("cm")

        val C = Label("Torso")
        val inputC = TextField("cm")

        val D = Label("Hips")
        val inputD = TextField("cm")

        val E = Label("Thighs")
        val inputE = TextField("cm")

//        val clickToSend = Button("Send")
        val doneButton = Button("Done")

        grid2.add(typeOfMeasuremt, 1, 4)
        grid2.add(input, 2, 4)

        grid2.add(A, 1, 5)
        grid2.add(inputA, 2, 5)

        grid2.add(B, 1, 6)
        grid2.add(inputB, 2, 6)

        grid2.add(C, 1, 7)
        grid2.add(inputC, 2, 7)

        grid2.add(D, 1, 8)
        grid2.add(inputD, 2, 8)

        grid2.add(E, 1, 9)
        grid2.add(inputE, 2, 9)

        grid2.add(doneButton, 2, 11)
//        grid2.add(clickToSend, 4, 11)

        grid2.hgap = 30.0
        grid2.vgap = 30.0

        doneButton.setOnAction(EventHandler { e: ActionEvent? ->
            if (inputA.text == null) {
                println("Input is null")
            }
            val d1 = inputA.text.toDouble()
            listOfMeasuremts!!.addLast(d1)
            println(d1)
            if (inputB.text == null) {
                println("Input is null")
            }
            val d2 = inputB.text.toDouble()
            listOfMeasuremts!!.addLast(d2)
            println(d2)
            if (inputC.text == null) {
                println("Input is null")
            }
            val d3 = inputC.text.toDouble()
            listOfMeasuremts!!.addLast(d3)
            println(d3)
            if (inputD.text == null) {
                println("Input is null")
            }
            val d4 = inputD.text.toDouble()
            listOfMeasuremts!!.addLast(d4)
            println(d4)
            if (inputE.text == null) {
                println("Input is null")
            }
            val d5 = inputE.text.toDouble()
            listOfMeasuremts!!.addLast(d5)
            println(d5)

        })


        doneButton.onAction = EventHandler { e: ActionEvent? ->
            val iv = ImageView()
            iv.image = anImage

            // to choose to preserve image's width and height
            iv.isPreserveRatio = false
            iv.rotate = 90.0
            iv.rotate = 360.0

            iv.fitWidth = 300.0
            iv.fitHeight = 300.0
            root.alignment = Pos.CENTER
            root.children.add(iv)


            val grid3 = GridPane()
            val backButton = Button("<- Back")
            val columnLeft = ColumnConstraints(100.0, 150.0, 200.0)
            val columnMid = ColumnConstraints(100.0, 150.0, 200.0)

            val rowMid1 = RowConstraints(20.0, 40.0, 60.0)
            val rowMid2 = RowConstraints(20.0, 40.0, 60.0)
            val rowMid3 = RowConstraints(20.0, 40.0, 60.0)
            val rowMid4 = RowConstraints(20.0, 40.0, 60.0)
            val rowMid5 = RowConstraints(20.0, 40.0, 60.0)
            val rowMid6 = RowConstraints(20.0, 40.0, 60.0)

            val rowMid7 = RowConstraints(20.0, 25.0, 40.0)
            val rowMid8 = RowConstraints(20.0, 25.0, 40.0)
            val rowMid9 = RowConstraints(20.0, 25.0, 40.0)
            val rowMid10 = RowConstraints(20.0, 25.0, 40.0)
            val rowMid11 = RowConstraints(20.0, 25.0, 40.0)
            val rowMid12 = RowConstraints(20.0, 25.0, 40.0)

            grid3.columnConstraints.addAll(columnLeft, columnMid)
            grid3.rowConstraints.addAll(
                rowMid1, rowMid2, rowMid3, rowMid4, rowMid5, rowMid6, rowMid7,
                rowMid8, rowMid9, rowMid10, rowMid11, rowMid12
            )

            root.children.removeAll(grid2)

            val customerInfo = Label("Customer Information:")
            customerInfo.font =
                Font.font(customerInfo.text, FontWeight.EXTRA_BOLD, 15.0)
            grid3.add(customerInfo, 1, rowNumber)

            val textFieldLeftLabel = Label(textFieldLeft!!.text)
            val textFieldRightLabel = Label(textFieldRight!!.text)
            val textFieldEmailLabel = Label(textFieldEmail!!.text)

            textFieldLeftLabel.font = Font.font(textFieldLeft!!.text, FontPosture.ITALIC, 20.0)
            textFieldRightLabel.font = Font.font(textFieldLeft!!.text, FontPosture.ITALIC, 20.0)
            textFieldEmailLabel.font = Font.font(textFieldLeft!!.text, FontPosture.ITALIC, 20.0)

            rowNumber = rowNumber + 1
            grid3.add(textFieldLeftLabel, 1, rowNumber)

            rowNumber = rowNumber + 1
            grid3.add(textFieldRightLabel, 1, rowNumber)

            rowNumber = rowNumber + 1
            grid3.add(textFieldEmailLabel, 1, rowNumber)

            rowNumber = rowNumber + 2
            val customerMeasuremts = Label("Customer Measurements:")
            customerMeasuremts.font =
                Font.font(customerMeasuremts.text, FontWeight.EXTRA_BOLD, 15.0)
            GridPane.setColumnSpan(customerMeasuremts, 2)
            grid3.add(customerMeasuremts, 1, rowNumber)

            rowNumber = rowNumber + 1
            listOfMeasuremts!!.forEach(Consumer { s: Double ->
                rowNumber = rowNumber + 1
                val t = s.toString()
                val displayMeasuremt = Label(t)
                displayMeasuremt.font = Font.font(t, FontPosture.ITALIC, 20.0)
                grid3.add(displayMeasuremt, 1, rowNumber)
            })
            root.children.add(grid3)
//            backButton.setOnActionClickListener{
//                onBackPressed()
//            }
        }

        root.children.removeAll(grid)
        root.children.add(grid2)
    }
}

    fun main() {
    Application.launch(HelloApplication::class.java)
}

//            if (inputF.text == null) {
//                println("Input is null")
//            }
//            val d6 = inputF.text.toDouble()
//            listOfMeasuremts!!.addLast(d6)
//            println(d6)
//            if (inputG.text == null) {
//                println("Input is null")
//            }
//            val d7 = inputG.text.toDouble()
//            listOfMeasuremts!!.addLast(d7)
//            println(d7)
//            if (inputH.text == null) {
//                println("Input is null")
//            }
//            val d8 = inputH.text.toDouble()
//            listOfMeasuremts!!.addLast(d8)
//            println(d8)
//            if (inputI.text == null) {
//                println("Input is null")
//            }
//            val d9 = inputI.text.toDouble()
//            listOfMeasuremts!!.addLast(d9)
//            println(d9)
//            if (inputJ.text == null) {
//                println("Input is null")
//            }
//            val d10 = inputJ.text.toDouble()
//            listOfMeasuremts!!.addLast(d10)
//            println(d10)
//        grid2.add(eleven, 4, 5)
//        grid2.add(seventeen, 5, 5)

//        grid2.add(F, 1, 6)
//        grid2.add(inputF, 2, 6)
//        grid2.add(thirteen, 4, 6)
//        grid2.add(sixteen, 5, 6)
//
//        grid2.add(G, 1, 7)
//        grid2.add(inputG, 2, 7)
//        grid2.add(twentyThree, 4, 7)
//        grid2.add(thirtyFour, 5, 7)
//
//        grid2.add(H, 1, 8)
//        grid2.add(inputH, 2, 8)
//        grid2.add(thirty, 4, 8)
//        grid2.add(fortyTwo, 5, 8)
//
//        grid2.add(I, 1, 9)
//        grid2.add(inputI, 2, 9)
//        grid2.add(twentyEight, 4, 9)
//        grid2.add(thirtySeven, 5, 9)
//
//        grid2.add(J, 1, 10)
//        grid2.add(inputJ, 2, 10)
//        grid2.add(twentyFour, 4, 10)
//        grid2.add(thirtySix, 5, 10)
//        totalMeasuremts.onAction = EventHandler { e: ActionEvent? ->
//            totalValues.text = inputA.text
//        }
//        val enterE = Button("enter E")
//        val enterF = Button("enter F")
//        val enterG = Button("enter G")
//        val enterH = Button("enter H")
//        val enterH = Button("enter H")
//        grid2.add(enterAmeasuremt, 3, 0)
//        val enterI = Button("enter I")
//        grid2.add(enterB, 3, 2)
//        val enterJ = Button("enter J")
//        grid2.add(enterA, 3, 1)
//        grid2.add(enterC, 3, 3)
//        grid2.add(enterD, 3, 4)
//        grid2.add(enterE, 3, 5)
//        grid2.add(enterF, 3, 6)
//        grid2.add(enterG, 3, 7)
//        grid2.add(enterH, 3, 8)
//        grid2.add(enterI, 3, 9)
//        grid2.add(enterJ, 3, 10)

//        String infoA = inputA.getText();
//        int numberA = Integer.parseInt(infoA);
//
//        String infoB = inputB.getText();
//        int numberB = Integer.parseInt(infoB);
//
//        int totalNumbers = numberA + numberB;
//
//        totalMeasuremts.setOnAction(e ->{
//            totalValues.setText(totalNumbers+"");
//        });
//            val grid3 = HBox()
// to choose to preserve image's width and height

//override fun start(stage: Stage) {
//    val fxmlLoader = FXMLLoader(HelloApplication::class.java.getResource("hello-view.fxml"))
//    val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
//    stage.title = "Hello!"
//    stage.scene = scene
//    stage.show()


//        enterA.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputA.text == null) {
//                println("Input is null")
//            }
//            val d = inputA.text.toDouble()
//            listOfMeasuremts?.addLast(d)
//            println(d)
//        })
//
//        enterB.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputB.text == null) {
//                println("Input is null")
//            }
//            val d = inputB.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//        enterC.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputC.text == null) {
//                println("Input is null")
//            }
//            val d = inputC.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//        enterD.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputD.text == null) {
//                println("Input is null")
//            }
//            val d = inputD.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//        enterE.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputE.text == null) {
//                println("Input is null")
//            }
//            val d = inputE.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//        enterF.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputF.text == null) {
//                println("Input is null")
//            }
//            val d = inputF.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//        enterG.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputG.text == null) {
//                println("Input is null")
//            }
//            val d = inputG.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//        enterH.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputH.text == null) {
//                println("Input is null")
//            }
//            val d = inputH.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//        enterI.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputI.text == null) {
//                println("Input is null")
//            }
//            val d = inputI.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })
//
//
//        enterJ.setOnAction(EventHandler { e: ActionEvent? ->
//            if (inputJ.text == null) {
//                println("Input is null")
//            }
//            val d = inputJ.text.toDouble()
//            listOfMeasuremts!!.addLast(d)
//            println(d)
//        })

//        grid2.add(totalMeasuremts, 1, 11)
//        grid2.add(totalValues, 2, 11)
//        grid2.add(ready, 3, 11)
//        grid2.add(clickToSend, 4, 11)
//            val thirdView = Label("third view")
//            grid3.children.addAll(thirdView)
//        grid2.children.addAll(newView)

//        val newView = Button("New View")
//       val enterA = Button("enter A")
//        val enterAmeasuremt = Label("Enter a measuremt")
//        val enterA = Button("enter A")
//        val enterC = Button("enter C")
//        val enterB = Button("enter B")
//        val enterD = Button("enter D")

//        val eleven = Label("11")
//        val seventeen = Label("17")

//        val F = Label("Half Length")
//        val inputF = TextField("input F")
//        val thirteen = Label("13")
//        val sixteen = Label("16")
//
//        val G = Label("Trouser Length")
//        val inputG = TextField("input G")
//        val twentyThree = Label("23")
//        val thirtyFour = Label("34")
//
//        val H = Label("Shirt Length")
//        val inputH = TextField("input H")
//        val thirty = Label("30")
//        val fortyTwo = Label("42")
//
//        val I = Label("Burst")
//        val inputI = TextField("input I")
//        val twentyEight = Label("28")
//        val thirtySeven = Label("37")
//
//        val J = Label("Lower Waist")
//        val inputJ = TextField("input J")
//        val twentyFour = Label("24")
//        val thirtySix = Label("36")
//
//        val totalMeasuremts = Button("Get Total Measurement")
//        val totalValues = TextField("Total Values")
//        val ready = Label("Ready")

//        val minInput = Label("Minimum Input")
//        val maxInput = Label("Maximum Input")
//        val nineteen = Label("19")
//        val twentyNine = Label("29")
//        val fifteen = Label("15")
//        val thirtyTwo = Label("32")
//        middleName = Label(
//            """
//                        Middle
//                        Name(Optional):
//                        """.trimIndent()
//        )
//    var middleName: Label? = null
//    var textFieldMidName: TextField? = null
//    var sendInfo: Label? = null
//        textFieldMidName!!.font = Font.font(textFieldMidName!!.text, FontPosture.ITALIC, 18.0)

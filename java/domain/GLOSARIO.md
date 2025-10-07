# 🗣️ Glosario del dominio de comercio

Este glosario muestra términos utilizados para ayuda entre desarrolladores, analistas y arquitectos.

---

## 📘 Términos prinicipales

| **Término** | **Definición** |
|--------------|----------------|
| **Producto** |Representa un producto del catálogo con sus atributos básicos. |
| **Carrito** | Carrito de compras asociado a un cliente.  Permite agregar items y calcular el total. |
| **ItemCarrito** | Representa un item en el carrito: un producto y la cantidad seleccionada. |
| **Pedido** | Representa un pedido que puede confirmarse o cancelarse.  Se asocia con el carrito y el pago, pero para simplificar no incluye esa lógica en el lugar. |
| **Pago** | Representa un pago asociado a un pedido.  Este objeto puede procesar un cobro utilizando el medio de pago seleccionado. |
| **Cliente** | Persona o entidad que navega el catálogo, agrega productos al carrito y realiza pedidos. |
| **Stock** | Cantidad disponible de un producto en inventario. Disminuye cuando se confirma un pedido. |
| **Total** | Suma monetaria del valor de los productos en un carrito o pedido. |
| **Medio de pago** | Método utilizado por el cliente para efectuar un pago (tarjeta, transferencia, efectivo, etc.). |

---

## 🧩 Contextos delimitados (Bounded Contexts)

| **Contexto** | **Descripción** | **Entidades principales** |
|---------------|-----------------|-----------------------------|
| **Catálogos** | Gestiona los productos disponibles y su stock. | `Producto` |
| **Ventas** | Maneja el proceso de selección de productos antes de la compra. | `Carrito`, `ItemCarrito` |
| **Ordenes** | Administra los pedidos confirmados y su estado. | `Pedido` |
| **Transacciones** | Controla las transacciones monetarias asociadas a los pedidos. | `Pago` |

---


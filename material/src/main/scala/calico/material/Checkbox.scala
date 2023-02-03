/*
 * Copyright 2023 Arman Bilge
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package calico.material

import calico.html.Prop
import cats.effect.kernel.Async

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

opaque type Checkbox[F[_]] <: fs2.dom.HtmlElement[F] = fs2.dom.HtmlElement[F]

private object Checkbox:
  @inline def apply[F[_]]: Checkbox[F[_]] = Raw().asInstanceOf[Checkbox[F]]

  @JSImport("@material/web/checkbox/checkbox.js")
  @js.native
  private class Raw extends js.Object

private trait MaterialCheckbox[F[_]](using F: Async[F]):

  def mdCheckbox: MdTag[F, Checkbox[F]] = MdTag(Checkbox[F])

  extension (checkbox: Checkbox[F])
    def checked: Prop[F, Boolean, Boolean] = Prop("checked", identity)